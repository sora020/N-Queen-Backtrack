#include <iostream>
#define n 4
bool isSafe(int a[n][n], int row, int col) {
    for(int i = 0; i < col; i++)
        if(a[row][i])
            return false;
    for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if(a[i][j])
            return false;
    for(int i = row, j = col; j >= 0 && i < n; i++, j--)
        if(a[i][j])
            return false;
    return true;
}

bool solveNQ(int a[n][n], int col) {
    if(col >= n)
        return true;
    for(int i = 0; i < n; i++) {
        if(isSafe(a, i, col)) {
            a[i][col] = 1;
            if (solveNQ(a, col + 1))
                return true;
            a[i][col] = 0;
        }
    }
    return false;
}

void print(int a[n][n]) {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++)
            std::cout<<a[i][j]<<"    ";
    std::cout<<"\n\n";
    }
}
bool solve() {
    int a[n][n] = {{0, 0, 0, 0},
                   {0, 0, 0, 0},
                   {0, 0, 0, 0},
                   {0, 0, 0, 0}
    };
    if(!solveNQ(a, 0)) {
        std::cout<<"Solution doesn't exist\n";
        return false;
    }
    print(a);
    return true;
}

int main() {
    solve();
    return 0;
}