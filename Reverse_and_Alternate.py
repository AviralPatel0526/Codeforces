def validate_segment(start_idx, end_idx, char_array):
    for idx in range(start_idx + 1, end_idx + 1):
        if char_array[idx] == char_array[idx - 1]:
            end_idx = idx - 1
            break
    while start_idx < end_idx:
        char_array[start_idx], char_array[end_idx] = char_array[end_idx], char_array[start_idx]
        start_idx += 1
        end_idx -= 1
    for idx in range(1, len(char_array)):
        if char_array[idx] == char_array[idx - 1]:
            return False
    return True

def main():
    test_cases = int(input())
    while test_cases > 0:
        test_cases -= 1
        length = int(input())
        binary_string = input()
        original_chars = list(binary_string)
        is_almost_alternating = True
        
        copy1 = list(binary_string)
        copy2 = list(binary_string)
        for i in range(1, length):
            if original_chars[i] == original_chars[i - 1]:

                if not validate_segment(0, i - 1, copy1) and not validate_segment(i, length - 1, copy2):
                    is_almost_alternating = False
                break  # Exit the loop as the decision is made

        print("YES" if is_almost_alternating else "NO")

if __name__ == "__main__":
    main()
