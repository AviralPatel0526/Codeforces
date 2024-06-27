from sys import stdin

input = stdin.readline

def sinput():
    return int(input().strip())

def linput():
    return list(map(int, input().strip().split()))

def solve():
    x, y, z, k = linput()
    min_count = -1  # Set to a very large number initially
    
    for i in range(1, x + 1):
        for j in range(1, y + 1):
            if k % (i * j) == 0:
                c = k // (i * j)
                if 1 <= c <= z:
                    count = (x - i + 1) * (y - j + 1) * (z - c + 1)
                    min_count = max(min_count, count)
    
    if min_count == -1:
        print(0)
    else:
        print(min_count)

if __name__ == "__main__":
    t = sinput()
    for _ in range(t):
        solve()
