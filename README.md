# Incubyte - Interview Task 📔

## Task Explanation

**Objective:** Given a string with numbers and delimiters, calculate the sum of all positive numbers.

### **Conditions to Consider:**
- **Empty Input:** Returns `0`
- **Single Number:** Returns the number itself if it is positive
- **Delimiter Handling:** Remove delimiters (comma, space, or custom delimiter) and compute the sum
- **Negative Numbers:** Throws `IllegalArgumentException` if any negative number is present

---

## Approach Explanation

- **Read the Input 📖**
- **Check if Empty:** If the input string is empty, return `0`.
- **Single Positive Number:** If there is only one number and it is positive, return that number.
- **Custom Delimiter Handling:** If the string starts with `//`, identify and use the custom delimiter to split the string.
     - If splitting fails, throw `IllegalArgumentException`.
- **Negative Number Check:** If any negative numbers are found, throw `IllegalArgumentException`.
- **Sum Calculation:** Sum the numbers extracted from the string and return the result.

---

## Test Cases: 🔍

## **Total Test Cases:** 12

###  **Some of important test cases are discussed below:**


### 1. Custom Delimiter
---
**Input:** `"//;\n1;2"`  
**Expected Output:** `3`

**Description:** Handles custom delimiters specified in the input string. The delimiter here is `;`.

---

### 2. Negative Numbers
---
**Input:** `"-1,2"`  
**Expected Output:** Exception with message `"Negative numbers not allowed: -1"`

**Description:** Throws an `IllegalArgumentException` when a negative number is present in the input string.

---

### 3. Numbers Exceeding Integer Limit
---
**Input:** `"21474836489"`  
**Expected Output:** Exception with message `"Invalid number format: 21474836489"`

**Description:** Checks and handles numbers that exceed the integer limit, throwing an appropriate exception.

---

### 4. Leading and Trailing Delimiters
---
**Input:** `",1,2"`  
**Expected Output:** Exception with message `"Invalid input format: leading delimiter"`

**Input:** `"1,2,"`  
**Expected Output:** Exception with message `"Invalid input format: trailing delimiter"`

**Description:** Throws an IllegalArgument exception for invalid input formats where delimiters are leading or trailing.

---

## Clone Repository:

- Clone the repository:

```bash
  git clone https://github.com/danishppatel/Task-Incubyte.git
```

## Technology Used

- **Java, Junit and, Maven**

> Made by Danish-Patel, from Dharmsinh Desai University.