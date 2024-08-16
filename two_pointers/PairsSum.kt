package two_pointers

object PairsSum {
    fun countPairs(nums: List<Int>, target: Int): Int {
        if (nums.size <= 1) {
            return 0
        }
        val sortedArray = nums.sorted()
        var result = 0
        var startIndex = 0
        var endIndex = startIndex + 1
        while (endIndex < sortedArray.size && startIndex < sortedArray.size - 1) {
            val sum = sortedArray[startIndex] + sortedArray[endIndex]
            when {
                sum < target -> {
                    result++
                    if (endIndex == sortedArray.size - 1) {
                        startIndex++
                        endIndex = startIndex + 1
                    } else {
                        endIndex++
                    }
                }

                else -> {
                    startIndex++
                    endIndex = startIndex + 1
                }
            }
        }
        return result
    }

}