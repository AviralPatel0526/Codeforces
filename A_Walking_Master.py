t=int(input())
while t!=0:
    t-=1
    a,b,c,d=map(int,input().split())
    diffy=d-b
    diffx=c-a
    if(diffx > diffy or diffy < 0):
        print(-1)
    else:
        a+=diffy
        print(diffy + a-c)

