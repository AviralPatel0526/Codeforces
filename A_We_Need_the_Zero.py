t=int(input())
while t!=0:
    t-=1
    n=int(input())
    l=list(map(int,input().split()))
    xors=0
    for i in l:
        xors^=i
    
    if n%2 == 0:
        if(xors == 0):
            print(0)
        else:
            print(-1)
    else:        
        print(xors)


#jab even times ek hi no ka xor karoge to 0 hi ayega na cuz a^a=0 aur odd times karoge to wahi no aa jaega cuz a^a^a=a        