"""
03_chain_of_thought.py
Demonstrates Chain-of-Thought (CoT) and Few-Shot Prompt Engineering.

Author: CodeByTushu
Website: https://codebytushu.com
"""

FEW_SHOT_COT_PROMPT = """
You are an expert DSA coding interview tutor. Break down problem solving using step-by-step reasoning.

Example 1:
Problem: Find the maximum sum subarray of size k.
Thought:
1. Brute force tests every subarray of length k in O(n*k) time.
2. We can optimize using a Fixed-Size Sliding Window.
3. Compute the sum of the first k elements.
4. Slide the window one step right: add incoming element, subtract outgoing element in O(1).
5. Track maximum sum observed.
Answer: O(N) time complexity and O(1) space complexity using Sliding Window.

Now Solve:
Problem: Check if a binary tree is symmetric around its center.
Thought:
"""

def solve_with_cot():
    print("=== Chain-of-Thought Prompt Engineering Pattern ===")
    print(FEW_SHOT_COT_PROMPT)
    print("1. A tree is symmetric if the left subtree is a mirror reflection of the right subtree.")
    print("2. Base cases: If both nodes are null, return true. If only one is null, return false.")
    print("3. Recursive condition: root1.val == root2.val AND isMirror(root1.left, root2.right) AND isMirror(root1.right, root2.left).")
    print("Answer: O(N) time and O(H) auxiliary recursion stack space.")

if __name__ == "__main__":
    solve_with_cot()
