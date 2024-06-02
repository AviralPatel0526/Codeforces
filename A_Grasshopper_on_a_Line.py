t=int(input())
while t!=0:
    t-=1
    x,k=map(int,input().split())
    if(x%k == 0):
        print(2)
        print(x-1,1)
    else:
        print(1)
        print(x)    