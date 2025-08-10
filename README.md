Q1# 🌀 Minimum in Rotated Sorted Array (Java)

## 📜 Problem Statement
Given a **sorted array** that has been **rotated** at an unknown pivot, find the **minimum element** in the array.  
The array **does not contain duplicates**.

**Example:**
Input: [4, 5, 6, 7, 0, 1, 2]
Output: 0

## 💡 Approach
### 🐢 Naive Approach
- **Idea:** Traverse the entire array and keep track of the minimum element.
- **Steps:**
  1. Initialize `minElement = arr[0]`
  2. Loop through the array:
     ```
     for each element e in arr:
         if e < minElement:
             minElement = e
     ```
  3. Return `minElement`.
- **Time Complexity:** `O(n)`  
- **Space Complexity:** `O(1)`

---

### 🚀 Optimal Approach (Binary Search)
We use a **modified Binary Search** to reduce time complexity to `O(log n)`.

**Steps:**
1. **Initialize pointers:**  
   - `low = 0`  
   - `high = n - 1`  

2. **Loop until `low < high`:**
   - Find middle index:  
     ```
     mid = low + (high - low) / 2
     ```
   - **Case 1:** If `arr[mid] > arr[high]` → Minimum lies in **right half** → `low = mid + 1`
   - **Case 2:** Else → Minimum lies in **left half** (including mid) → `high = mid`

3. **Return:** `arr[low]` as the smallest element.

✅ This approach leverages the sorted + rotated property to skip unnecessary comparisons.


Q2# Subarray Sum Equals K

## 📌 Problem Statement
Given an array of integers and an integer `k`, find the total number of continuous subarrays whose sum equals `k`.


## 🚀 Approach
### **Naive Approach (O(n²))**
1. Iterate through all possible starting points of subarrays.
2. For each starting point, compute the sum for every ending point.
3. If the sum equals `k`, increment the count.
4. **Drawback**: Very slow for large arrays due to nested loops.

### **Optimized Approach - Prefix Sum + HashMap (O(n))**
1. Use a running sum (`currSum`) to store the prefix sum while iterating through the array.
2. Maintain a `HashMap` where:
   - **Key** → Prefix sum value.
   - **Value** → Number of times this prefix sum has occurred.
3. At each step:
   - Check if `(currSum - k)` exists in the map.
     - If yes, it means there’s a subarray ending here whose sum equals `k`.
   - Add/update the current prefix sum in the map.
4. Return the total count after iterating.

## 📊 Example
**Input**  
arr = [1, 2, 3]
k = 3

**Output**  
2

## 📊 Complexity Analysis
- **Time Complexity** → `O(n)` (Single pass over the array)
- **Space Complexity** → `O(n)` (HashMap to store prefix sums)
