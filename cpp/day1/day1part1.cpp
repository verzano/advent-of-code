#include <vector>
#include "iostream"
#include "fstream"
using namespace std;

int main() {
    ifstream in;

    // Have to ensure the right working directory for this to actually load the file
    in.open("input.txt");
    if (in.is_open()) {
        string line;
        vector<int> nums;
        while (getline(in, line)) {
            int currentNum = stoi(line);
            for (int oldNum : nums) {
                if (oldNum + currentNum == 2020) {
                    cout << (oldNum * currentNum) << '\n';
                    in.close();
                    return 1;
                }
            }
            nums.push_back(currentNum);
        }
        in.close();
    }

    return -1;
}
