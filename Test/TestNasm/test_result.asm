global    main
global    a


section .data
extern scanf
extern printf
extern puts
extern strlen
extern memcpy
extern sscanf
extern sprintf
extern malloc
extern strcmp

section .text

a:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  232
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  rdx
       mov  qword [rbp-32],  rcx
       mov  qword [rbp-40],  r8
       mov  qword [rbp-48],  r9
       mov  rax,  qword [rbp+80]
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp+72]
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp+64]
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp+56]
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp+48]
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp+40]
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp+32]
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp+24]
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp+16]
       mov  qword [rbp-120],  rax
       mov  rcx,  qword [rbp-8]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-16]
       add  rax,  rdx
       mov  qword [rbp-128],  rax
       mov  rcx,  qword [rbp-128]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-24]
       add  rax,  rdx
       mov  qword [rbp-136],  rax
       mov  rcx,  qword [rbp-136]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-32]
       add  rax,  rdx
       mov  qword [rbp-144],  rax
       mov  rcx,  qword [rbp-144]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-40]
       add  rax,  rdx
       mov  qword [rbp-152],  rax
       mov  rcx,  qword [rbp-152]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-48]
       add  rax,  rdx
       mov  qword [rbp-160],  rax
       mov  rcx,  qword [rbp-160]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-56]
       add  rax,  rdx
       mov  qword [rbp-168],  rax
       mov  rcx,  qword [rbp-168]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-64]
       add  rax,  rdx
       mov  qword [rbp-176],  rax
       mov  rcx,  qword [rbp-176]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-72]
       add  rax,  rdx
       mov  qword [rbp-184],  rax
       mov  rcx,  qword [rbp-184]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-80]
       add  rax,  rdx
       mov  qword [rbp-192],  rax
       mov  rcx,  qword [rbp-192]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-88]
       add  rax,  rdx
       mov  qword [rbp-200],  rax
       mov  rcx,  qword [rbp-200]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-96]
       add  rax,  rdx
       mov  qword [rbp-208],  rax
       mov  rcx,  qword [rbp-208]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-104]
       add  rax,  rdx
       mov  qword [rbp-216],  rax
       mov  rcx,  qword [rbp-216]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-112]
       add  rax,  rdx
       mov  qword [rbp-224],  rax
       mov  rcx,  qword [rbp-224]
       mov  rax,  rcx
       mov  rdx,  qword [rbp-120]
       add  rax,  rdx
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-232]
       add  rsp,  232
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  24
       mov  rdi,  1
       mov  rsi,  2
       mov  rdx,  3
       mov  rcx,  4
       mov  r8,  5
       mov  r9,  6
       mov  rax,  7
       push  rax
       mov  rax,  8
       push  rax
       mov  rax,  9
       push  rax
       mov  rax,  10
       push  rax
       mov  rax,  11
       push  rax
       mov  rax,  12
       push  rax
       mov  rax,  13
       push  rax
       mov  rax,  14
       push  rax
       mov  rax,  15
       push  rax
       call  a
       add  rsp,  72
       mov  qword [rbp-24],  rax
       mov  rdi,  qword [rbp-24]
       call  toString
       mov  qword [rbp-16],  rax
       mov  rdi,  qword [rbp-16]
       call  println
       mov  qword [rbp-8],  rax
       mov  rax,  0
       add  rsp,  24
       pop  rbp
       ret  

section .data

section .bss

section .data
intbuffer:
    dq 0
format1:
    db"%lld",0
format2:
    db"%lld ",10,0
format3:
    db"%s",0
format4:
    db"%s",10,0

section .bss
stringbuffer:
    resb 256

section .text
getInt:

    push rbp
    mov rbp,rsp
    mov rax,0
    mov rdi,format1
    mov rsi,intbuffer
    call scanf
    mov rax,[intbuffer]
    mov rsp,rbp
    pop rbp
    ret

printInt:
    push rbp
    mov rbp,rsp
    mov rsi,rdi
    mov rax,0
    mov rdi,format2
    call printf
    mov rsp,rbp
    pop rbp
    ret

size:
    mov rax,[rdi-8]
    ret

print:
    push rbp
    mov rbp,rsp
    mov rax,0
    mov rsi,rdi
    mov rdi,format3
    call printf
    mov rsp,rbp
    pop rbp
    ret

println:

    call puts
    ret


transtring:

    push rbp
    mov rbp,rsp
    call strlen
    push rdi
    mov rdi,rax
    push rdi
    add rdi,9
    call malloc
    pop rdi
    mov [rax],rdi
    add rax,8
    mov rdx,rdi
    add rdx,1
    mov rdi,rax
    pop rsi
    sub rsp,8
    push rax
    call memcpy
    pop rax
    mov rsp,rbp
    pop rbp
    ret

getString:

    push rbp
    mov rbp,rsp
    mov rax,0
    mov rdi,format3
    mov rsi,stringbuffer
    call scanf
    mov rdi,stringbuffer
    call transtring
    mov rsp,rbp
    pop rbp
    ret


ALIGN   16

toString:
        push    rbx
        mov     rbx, rdi
        mov     edi, 20
        call    malloc
        test    rbx, rbx
        mov     r9, rax
        lea     rdi, [rax+8H]
        js      L_007
        jne     L_010
        lea     rcx, [rax+9H]
        mov     byte [rax+8H], 48
        mov     rsi, rcx
L_004:  mov     rax, rcx
        mov     byte [rcx], 0
        sub     rax, rdi
        mov     qword [r9], rax
        lea     rax, [rcx-1H]
        cmp     rax, rsi
        jc      L_006
L_005:  movzx   edx, byte [rsi]
        movzx   ecx, byte [rax]
        add     rsi, 1
        sub     rax, 1
        mov     byte [rsi-1H], cl
        mov     byte [rax+1H], dl
        cmp     rsi, rax
        jbe     L_005
L_006:  mov     rax, rdi
        pop     rbx
        ret





ALIGN   8
L_007:  lea     rsi, [rax+9H]
        mov     byte [rax+8H], 45
        neg     rbx
L_008:  mov     rcx, rsi
        mov     r8, qword 6666666666666667H




ALIGN   16
L_009:  mov     rax, rbx
        add     rcx, 1
        imul    r8
        mov     rax, rbx
        add     ebx, 48
        sar     rax, 63
        sar     rdx, 2
        sub     rdx, rax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     ebx, eax
        test    rdx, rdx
        mov     byte [rcx-1H], bl
        mov     rbx, rdx
        jnz     L_009
        jmp     L_004





ALIGN   8
L_010:  mov     rsi, rdi
        jmp     L_008



length:

    mov rax,[rdi-8]
    ret


ALIGN   8

substring:
        push    r13
        sub     rdx, rsi
        push    r12
        push    rbp
        push    rbx
        mov     r12, rdi
        lea     rbx, [rdx+1H]
        lea     rdi, [rdx+0AH]
        mov     rbp, rsi
        sub     rsp, 8
        call    malloc
        test    rbx, rbx
        mov     r13, rax
        mov     qword [rax], rbx
        lea     rcx, [rax+8H]
        jle     L_003
        lea     rsi, [r12+rbp]
        mov     rdi, rcx
        mov     rdx, rbx
        call    memcpy
        mov     rcx, rax
L_003:  mov     byte [r13+rbx+8H], 0
        add     rsp, 8
        mov     rax, rcx
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        ret


        nop


parseInt:

    mov rsi,format1
    mov rdx,intbuffer
    mov rax,0
    call sscanf
    mov rax,[intbuffer]
    ret

ord:

    mov rax,0
    mov al,byte[rdi+rsi]
    ret

Str_ADD:
        push    r15
        push    r14
        mov     r15, rdi
        push    r13
        push    r12
        mov     r14, rsi
        push    rbp
        push    rbx
        sub     rsp, 8
        mov     rbp, qword [rdi-8H]
        mov     r12, qword [rsi-8H]
        lea     rbx, [rbp+r12]
        lea     rdi, [rbx+9H]
        call    malloc
        test    rbp, rbp
        mov     qword [rax], rbx
        mov     r13, rax
        lea     rbx, [rax+8H]
        jle     L_001
        mov     rdx, rbp
        mov     rsi, r15
        mov     rdi, rbx
        call    memcpy
L_001:  add     rbx, rbp
        test    r12, r12
        jle     L_002
        lea     rdi, [r13+rbp+8H]
        mov     rdx, r12
        mov     rsi, r14
        call    memcpy
L_002:  mov     byte [rbx+r12], 0
        mov     rax, rbx
        add     rsp, 8
        pop     rbx
        sub     rax, rbp
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret


Str_LT:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setl dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_LE:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setle dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_GT:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setg dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_GE:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setge dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_EQ:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    sete dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_NE:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setne dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret
