def getMaximumValue(weights, values, n, maxWeight):
    dp = [0] * (maxWeight + 1)
    n = len(weights)
    for j in range(1, maxWeight + 1):
        for i in range(n):
            if j >= weights[i]:
                dp[j] = max(dp[j], dp[j - weights[i]] + values[i])
    return dp[maxWeight]
