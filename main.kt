import two_pointers.ThreeSum

fun main() {
    println(ThreeSum.threeSum2(intArrayOf(-2,-3,0,0,-2)))
}
class Solution {
    fun lengthOfLastWord(s: String): Int {
        var count = 0
        for (i in s.length - 1 downTo 0) {
            if (count!=0 && s[i] == ' '){
                break
            }else if (s[i] != ' '){
                count++
            }
        }
    return count
    }
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--
                        left++
                        right--
                    }
                    sum < 0 -> left++
                    else -> right--
                }
            }
        }
        return result
    }

}
