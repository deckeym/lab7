#include <iostream>
#include <string>
#include <cctype>

using namespace std;

string decodeString(const string& s, int& i) {
    string result;

    while (i < s.size() && s[i] != ']') {
        if (isdigit(s[i])) {                                    // Считываем число k
            int k = 0;
            while (i < s.size() && isdigit(s[i])) {
                k = k * 10 + (s[i] - '0');
                i++;
            }                                                    
            i++;                                                // Пропускаем '['
            string decodedString = decodeString(s, i);          // Декодируем содержимое внутри '[' и ']'
            i++;                                                    // Пропускаем ']'
            while (k-- > 0) {                                     // Добавляем декодированную строку k раз в результат
                result += decodedString;
            }
        } 
        else 
        {                                                     // Если текущий символ не цифра, добавляем его к результату
            result += s[i++];
        }
    }
    return result;
}

string decodeString(const string& s) {
    int i = 0;
    return decodeString(s, i);
}

int main() 
{
    string encoded;
    cout << "Enter string - ";
    cin >> encoded;
    cout << endl << "Result - " << decodeString(encoded);
}
