t = int(input())
for i in range(t):
    n = int(input())
    elements = list(map(int, input().split()))
    tot_sum = sum(elements)
    if tot_sum % 2 == 0:
        print("YES")
    else:
        print("NO")
