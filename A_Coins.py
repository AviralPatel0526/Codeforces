t=int(input())
while t!=0:
    t-=1
    n,k=map(int,input().split())
    if n%2 == 0:
        print("YES")
    else:
        if k%2 == 1:
            print("YES")
        else:
            print("NO")