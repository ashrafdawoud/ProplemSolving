package two_pointers

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * --------------------------------------------------------------------------------------
 * this problem needs 2 pointers inward technique
 * we will use the loop index to access base item then we will apply technique after this index
 *
 *  [-4, -1, -1, 0, 1, 2]
 *    ^   ^            ^
 *    |   |            |
 *    |  startIndex  endIndex
 * base i
 *
 *  */

object ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val sortedArray = nums.sortedArray()

        for (i in sortedArray.indices) {
            /**
             * if (i > 0 && sortedArray[i] == sortedArray[i - 1]) continue
             * we need this condition so if array have duplicated base items we will skip them
             * as the same operation will run on it
             *
             * [-4, -1, -1, 0, 1, 2]
             *          ^    ^     ^
             *          |    |     |
             *          |    |    endIndex
             *          |     startIndex
             *      base i
             *
             *     so here base i is -1 and previous item is -1 so no need to repeat
             * */
            if (i > 0 && sortedArray[i] == sortedArray[i - 1]) continue

            var startIndex = i + 1
            var endIndex = sortedArray.size - 1
            while (startIndex < endIndex) {
                val sum = sortedArray[startIndex] + sortedArray[endIndex] + sortedArray[i]
                when {
                    sum == 0 -> {
                        result.add(listOf(sortedArray[i], sortedArray[startIndex], sortedArray[endIndex]))
                        /**
                         * we need this condition so if array have duplicated startIndex items we will skip them
                         * */
                        while (startIndex < endIndex && sortedArray[startIndex] == sortedArray[startIndex + 1]) startIndex++
                        /**
                         * we need this condition so if array have duplicated endIndex items we will skip them
                         * */
                        while (startIndex < endIndex && sortedArray[endIndex] == sortedArray[endIndex - 1]) endIndex--
                        /**
                         * after these checks we add i to startIndex and delete 1 from endIndex
                         * so we can apply these operation on another two items
                         * */
                        endIndex--
                        startIndex++
                    }
                    /**
                     * if sum is bigger than zero so we will Subtract endIndex by 1
                     * as this is sorted array and we want to try with smaller value
                     * */
                    sum > 0 -> endIndex--
                    else -> startIndex++
                }
            }
        }
        return result
    }
}