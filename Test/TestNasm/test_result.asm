global    main
section .text

main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  24
       mov  qword [rbp-0],  5
       mov  rax,  qword [rbp-0]
       add  rcx,  1
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-16]
       add  rax,  rdx
       mov  rdx,  qword [rbp-0]
       add  rax,  rdx
       add  rsp,  24
       pop  rbp
       ret  


section .data

section .bss

