package domain;

import state.Result;

import java.util.*;
import java.util.stream.Collectors;

public class TotalResult {
    private final Map<Result, Integer> totalResult;

    public TotalResult() {
        totalResult = new HashMap<>();
        Arrays.stream(Result.values()).forEach(result -> totalResult.put(result, 0));
    }

    public TotalResult(Map<Result, Integer> totalResult) {
        this();
        this.totalResult.putAll(totalResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalResult that = (TotalResult) o;
        return Arrays.stream(Result.values())
                .allMatch(result -> this.totalResult.get(result) ==
                        that.totalResult.get(result));

    }

    @Override
    public int hashCode() {
        return Objects.hash(totalResult);
    }

    public void increaseValueOfResult(Result result) {
        Integer previousValue = this.getValueOfResult(result);
        totalResult.put(result, previousValue + 1);
    }

    public int getValueOfResult(Result result) {
        return totalResult.get(result);
    }

    private int getWinningOfResult(Result result) {
        return getValueOfResult(result) * result.getWinnings();
    }
    public double getProfit(int paidPrice) {
        Integer winnings = Arrays.stream(Result.values()).map(this::getWinningOfResult).reduce(Integer::sum).orElse(0);
        return Math.floor((double) winnings * 100.0/ (double) paidPrice) / 100.0;
    }
    
    public List<String> getTotalResultMessage() {
        return Arrays.stream(Result.values())
                .filter(result -> result != Result.NONE)
                .map(result -> String.format("%s (%d원)- %d개",
                        result.getDescription(),
                        result.getWinnings(),
                        this.getValueOfResult(result)))
                .collect(Collectors.toList());
    }
    
    public String getProfitMessage(double profit) {
        String message = String.format("총 수익률은 %.2f입니다.", profit);
        if (profit <= 1) {
            return message + "(기준이 1이기 때문에 손해입니다.)";
        }
        return message + "(기준이 1이기 때문에 이득입니다.)";
    }
}
