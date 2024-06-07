def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    return abs(a * b) // gcd(a, b)

t = int(input())

while t != 0:
    t -= 1
    n = int(input())
    l = list(map(int, input().split()))
    totLcm = 1
    for i in l:
        totLcm = lcm(totLcm, i)
    ln = []
    total_sum = 0
    for i in range(n):
        ln_value = totLcm // l[i]
        ln.append(ln_value)
        total_sum += ln_value
    flag = True
    for i in range(n):
        if ln[i] * l[i] <= total_sum:
            flag = False
            break
    if flag:
        print(" ".join(map(str, ln)))
    else:
        print(-1)
