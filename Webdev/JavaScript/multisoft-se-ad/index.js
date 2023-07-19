s = ""
a = [3, 8, 5, 1, 8, 5, 3, 2, 1]
i = 0

while (i < a.length) {
    if (a[i] % 2 != 0) {
        s += a[i] + a[a[i]]
        i += 2
    } else {
        i -= 1
    }
}

console.log('https://www.multisoft.se/' + s)




