global    main
section .text

main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  24
       mov  qword [rbp-0],  5
       mov  rax,  qword [rbp-0]
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-0]
       imul  rax,  2
       mov  rcx,  qword [rbp-8]
       add  rax,  rcx
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       add  rsp,  24
       pop  rbp
       ret  


section .data

section .bss

