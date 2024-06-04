t=int(input())
while t!=0:
    t-=1
    n=int(input())
    l=list(map(int,input().split()))
    xors=0
    for i in l:
        xors^=i
    
    
    print(xors)