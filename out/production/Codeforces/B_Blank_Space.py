t=int(input())
while t!=0:
    t-=1
    n=int(input())
    l=list(map(int,input().split()))
    m=0
    c=0
    for i in l:
        if(i != 0):
            m=max(m,c)
            c=0
        else:
            c+=1
    m=max(m,c)
    print(m)