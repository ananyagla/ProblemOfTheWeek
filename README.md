# 🌀 Minimum in Rotated Sorted Array (Java)

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
