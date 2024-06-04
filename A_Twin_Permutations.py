t=int(input())
while t!=0:
    t-=1
    n=int(input())
    l=list(map(int,input().split()))
    m=max(l)+1
    for i in l:
        print(m-i,end=" ")
    print()    
