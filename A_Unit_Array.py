t=int(input())
while t!=0:
    t-=1
    n=int(input())
    l=list(map(int,input().split()))
    cneg=0
    for i in l:
        if(i == -1):
            cneg+=1
    cpos=n-cneg
    if cneg > cpos:
        a=cneg-cpos
        if(a%2 == 0):
            a//=2
        else:
            a=a//2+1
        cneg-=a
        if(cneg%2 != 0):
            a+=1
        print(a)    
    else:
        if(cneg%2 == 0):
            print(0)
        else:
            print(1)