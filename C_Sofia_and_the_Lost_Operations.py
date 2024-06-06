def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    index = 0
    t = int(data[index])
    index += 1
    
    results = []
    
    while t != 0:
        t -= 1
        n = int(data[index])
        index += 1
        a = []
        for _ in range(n):
            a.append(int(data[index]))
            index += 1
        
        b = []
        set_b = set()
        map_b = {}
        for i in range(n):
            b_val = int(data[index])
            b.append(b_val)
            index += 1
            if b_val != a[i]:
                if b_val in map_b:
                    map_b[b_val] += 1
                else:
                    map_b[b_val] = 1
            set_b.add(b_val)
        
        m = int(data[index])
        index += 1
        d = []
        for _ in range(m):
            d.append(int(data[index]))
            index += 1
        
        flag = True
        for x in d:
            if x in set_b:
                if x in map_b:
                    map_b[x] -= 1
                    if map_b[x] == 0:
                        del map_b[x]
                flag = True
            else:
                flag = False
        
        if flag and len(map_b) == 0:
            results.append("YES")
        else:
            results.append("NO")
    
    print("\n".join(results))

if __name__ == "__main__":
    main()
