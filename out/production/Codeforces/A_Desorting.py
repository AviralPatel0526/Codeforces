t=int(input())
while (t!=0):
    t=t-1
    n=int(input())
    l=list(map(int,input().split()))
    m=10**9
    for i in range(1,len(l)):
        m=min(m,l[i]-l[i-1])
    if m < 0:
        print(0)
    else:
        print(m//2 + 1)
