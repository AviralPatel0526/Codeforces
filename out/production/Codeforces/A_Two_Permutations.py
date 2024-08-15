t=int(input())
while t!=0:
    t-=1
    n,a,b=map(int,input().split())
    if(n==a and n==b):
        print("Yes")
    else:
        k=n-a-b
        if(k >= 2):
            print("Yes")
        else:
            print("No")