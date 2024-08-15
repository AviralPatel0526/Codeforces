from collections import *
from math import *
from sys import *
from heapq import *

input = stdin.readline
def sinput():
    return int(input())

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
    n=sinput()
    l=linput()
    if n % 2 == 0:
        print(2)
        print(1,n)
        print(1,n)
    else:
        print(4)
        print(1,n-1)
        print(1,n-1)
        print(n-1,n)
        print(n-1,n)

for _ in range(int(input())):
    solve()