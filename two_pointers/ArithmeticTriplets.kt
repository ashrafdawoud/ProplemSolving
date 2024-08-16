package two_pointers
/**
 * 2367. Number of Arithmetic Triplets
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 *
 * You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
 *
 *     i < j < k,
 *     nums[j] - nums[i] == diff, and
 *     nums[k] - nums[j] == diff.
 *
 * Return the number of unique arithmetic triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,4,6,7,10], diff = 3
 * Output: 2
 * Explanation:
 * (1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
 * (2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,8,9], diff = 2
 * Output: 2
 * Explanation:
 * (0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
 * (1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.
 *
 *
 * */
object ArithmeticTriplets {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        if (nums.size < 3) return 0
        var resultPairs = 0
        for (i in 0..nums.size - 2) {
            var startIndex = i+1
            var endIndex = nums.size - 1
            while (startIndex < endIndex) {
                val fDiff = nums[startIndex] - nums[i]
                val sDiff = nums[endIndex] - nums[startIndex]
                when {
                    fDiff == diff -> {
                        if (sDiff == diff) {
                            resultPairs++
                        }else if (sDiff < diff) break
                        endIndex--
                    }

                    fDiff < diff -> {
                        startIndex++
                    }
                    else -> {
                        break
                    }
                }
            }
        }
        return resultPairs
    }
}