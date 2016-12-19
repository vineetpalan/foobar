
def answer(M,F):
    m = int(M)
    f = int(F)

    output = "impossible"
    count = 0

    while (m > 1 or f > 1):
        if not checkIsValid(m, f):
            m = f = 0
        elif f == 1 and m>1:
            count += (m-1)
            return str(count)
        elif m == 1 and f>1:
            count += (f-1)
            return str(count)
        elif m > f:
            sub1 = m/f
            m = m - (f * sub1)
            count += sub1
        elif f > m :
            sub2 = (f/m)
            f = f - (m * sub2)
            count += sub2

    if m == 1 and f == 1:
        output = str(count)

    return output

def checkIsValid(m,f):
    valid = True
    if m % 2 == 0 and f % 2 == 0:
        valid = False
    elif m == f:
        valid = False
    elif m <= 0 or f <= 0:
        valid = False
    elif m > 1 and (f % m) == 0:
        valid = False
    elif f > 1 and (m % f) == 0:
        valid = False
    return valid


print answer(str(43),str(7))

