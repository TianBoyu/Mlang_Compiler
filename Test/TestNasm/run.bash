nasm -felf64 test_result.asm
gcc --static test_result.o
./a.out

