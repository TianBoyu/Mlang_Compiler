global    M
global    check
global    N
global    main


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

main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  256
       call  getInt
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword[N],  rax
       mov  rax,  qword[N]
       add  rax,  5
       mov  qword [rbp-24],  rax
       mov  rcx,  qword [rbp-24]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rcx,  qword [rbp-24]
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  rcx
       mov  rax,  qword [rbp-16]
       mov  qword[check],  rax
       mov  qword [rbp-32],  0
label2:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jg  label1
label0:
       mov  rax,  qword [rbp-32]
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       mov  rax,  qword[check]
       mov  rcx,  qword [rbp-48]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  1
       jmp  label2
label1:
       mov  rax,  qword[N]
       add  rax,  5
       mov  qword [rbp-72],  rax
       mov  rcx,  qword [rbp-72]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-64],  rax
       mov  rcx,  qword [rbp-72]
       mov  rax,  qword [rbp-64]
       mov  qword [rax + 0],  rcx
       mov  rax,  qword [rbp-64]
       mov  qword [rbp-56],  rax
       mov  rax,  qword[N]
       add  rax,  5
       mov  qword [rbp-96],  rax
       mov  rcx,  qword [rbp-96]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-88],  rax
       mov  rcx,  qword [rbp-96]
       mov  rax,  qword [rbp-88]
       mov  qword [rax + 0],  rcx
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-56]
       mov  qword [rax + 16],  1
       mov  qword [rbp-32],  2
label5:
label3:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jle  label8
label7:
       jmp  label4
       jmp  label9
label8:
       jmp  label9
label9:
       mov  rcx,  qword[check]
       mov  rdx,  qword [rbp-32]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jz  label11
label10:
       mov  rax,  qword[M]
       add  rax,  1
       mov  qword[M],  rax
       mov  rdx,  qword [rbp-32]
       mov  rax,  qword [rbp-80]
       mov  rcx,  qword[M]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rax,  qword [rbp-32]
       sub  rax,  1
       mov  qword [rbp-112],  rax
       mov  rdx,  qword [rbp-112]
       mov  rax,  qword [rbp-56]
       mov  rcx,  qword [rbp-32]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       jmp  label12
label11:
       jmp  label12
label12:
       mov  rax,  qword [rbp-32]
       mov  qword [rbp-120],  rax
       mov  qword [rbp-128],  1
label15:
       mov  rcx,  qword [rbp-128]
       mov  rdx,  qword[M]
       cmp  rcx,  rdx
       jg  label14
       jg  label14
label17:
       mov  rax,  qword [rbp-120]
       mov  rdx,  qword [rbp-80]
       mov  rbx,  qword [rbp-128]
       add  rbx,  1
       mov  rsi,  qword [rdx + rbx * 8]
       imul  rax,  rsi
       mov  qword [rbp-144],  rax
       mov  rcx,  qword [rbp-144]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jg  label14
       jg  label14
label13:
       mov  rax,  qword [rbp-120]
       mov  rdx,  qword [rbp-80]
       mov  rbx,  qword [rbp-128]
       add  rbx,  1
       mov  rsi,  qword [rdx + rbx * 8]
       imul  rax,  rsi
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-168]
       mov  qword [rbp-160],  rax
       mov  rcx,  qword [rbp-160]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jle  label19
label18:
       jmp  label16
       jmp  label20
label19:
       jmp  label20
label20:
       mov  rax,  qword[check]
       mov  rcx,  qword [rbp-160]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  0
       mov  rax,  qword [rbp-120]
       mov  rdx,  rax
       mov  rcx,  qword [rbp-80]
       mov  rbx,  qword [rbp-128]
       add  rbx,  1
       mov  rsi,  qword [rcx + rbx * 8]
       mov  rdx,  0
       idiv  rsi
       mov  qword [rbp-184],  rdx
       mov  rcx,  qword [rbp-184]
       cmp  rcx,  0
       jne  label22
label21:
       mov  rcx,  qword [rbp-56]
       mov  rdx,  qword [rbp-120]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  rsi,  qword [rbp-80]
       mov  rdi,  qword [rbp-128]
       add  rdi,  1
       mov  r8,  qword [rsi + rdi * 8]
       imul  rax,  r8
       mov  qword [rbp-200],  rax
       mov  rdx,  qword [rbp-200]
       mov  rax,  qword [rbp-56]
       mov  rcx,  qword [rbp-160]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       jmp  label14
       jmp  label23
label22:
       mov  rax,  qword [rbp-120]
       mov  rdx,  qword [rbp-80]
       mov  rbx,  qword [rbp-128]
       add  rbx,  1
       mov  rsi,  qword [rdx + rbx * 8]
       imul  rax,  rsi
       mov  qword [rbp-208],  rax
       mov  rcx,  qword [rbp-80]
       mov  rdx,  qword [rbp-128]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       sub  rax,  1
       mov  qword [rbp-216],  rax
       mov  rcx,  qword [rbp-56]
       mov  rdx,  qword [rbp-120]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  rsi,  qword [rbp-216]
       imul  rax,  rsi
       mov  qword [rbp-224],  rax
       mov  rdx,  qword [rbp-224]
       mov  rax,  qword [rbp-56]
       mov  rcx,  qword [rbp-208]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       jmp  label23
label23:
label16:
       mov  rax,  qword [rbp-128]
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-128]
       add  rax,  1
       mov  qword [rbp-128],  rax
       jmp  label15
label14:
       mov  rax,  qword [rbp-56]
       mov  rcx,  qword [rbp-120]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-240],  rax
       mov  rax,  qword [rbp-240]
       mov  rdi,  rax
       call  println
label6:
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       jmp  label5
label4:
       mov  rax,  0
       add  rsp,  256
       pop  rbp
       ret  

section .data
M:
       dq  0

section .bss

N:       resq  1
check:       resq  1


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
    mov rax,[rdi]
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
