n, k, x = map(int, input().split())
a = list(map(int, input().split()))

a.sort()

gp = []
for i in range(1, n):
    if a[i] - a[i - 1] > x:
        gp.append(a[i] - a[i - 1])

if k == 0:
    print(len(gp) + 1)
else:
    gp.sort()
    tg = len(gp)
    for gap in gp:
        sub = (gap + x - 1) // x - 1  # Equivalent to ceil(gap / x) - 1
        if k >= sub:
            k -= sub
            tg -= 1
        else:
            break
    print(tg + 1)
