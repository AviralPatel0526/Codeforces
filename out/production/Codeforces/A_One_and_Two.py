t=int(input())
while t!=0:
    t-=1
    n=int(input())
    l=list(map(int,input().split()))
    lmul=1
    for i in l:
        lmul*=i
    lmul2=1
    ind=-2
    for i in range(n):
        lmul2*=l[i]
        lmul//=l[i]
        if(lmul2 == lmul):
            ind=i
            break
    print(ind+1)
