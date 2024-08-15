from collections import *
from math import *
from sys import *
from heapq import *

input = stdin.readline

def linput():
    return list(map(int,input().split()))

def printl(l):
    return print(' '.join(map(str,l)))

def convertBits(l):
    for x in range(len(l)):
        l[x] = [*bin(l[x]).replace('0b', '')]
        l[x] = ['0']*(32-len(l[x]))+l[x]
        l[x] = l[x][::-1]

# remember binary search
# bitwise operator -> bitmask
def solve():
    a,b,n=linput()
    l=linput()
    s=b
    for i in l:
        s+=min(a-1,i)
    print(s)

for _ in range(int(input())):
    solve()