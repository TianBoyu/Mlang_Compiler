global    j
global    printNum
global    b
global    a
global    i
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

printNum:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  32
       mov  qword [rbp-8],  rdi
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  println
       add  rsp,  32
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  240
       mov  rdi,  40
       call  malloc
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword [rax + 0],  4
       mov  qword [rbp-16],  0
       mov  rax,  qword [rbp-8]
       mov  qword[a],  rax
       mov  rdi,  48
       call  malloc
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rax + 0],  5
       mov  rax,  qword [rbp-24]
       mov  qword[b],  rax
       mov  qword[i],  0
label4:
       mov  rcx,  qword[i]
       cmp  rcx,  4
       jge  label7
label6:
       mov  qword [rbp-8],  1
       jmp  label8
label7:
       mov  qword [rbp-8],  0
label8:
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  0
       jz  label3
label2:
       mov  rdi,  96
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  11
       mov  rdx,  qword [rbp-16]
       mov  rax,  qword[a]
       mov  rcx,  qword[i]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
label5:
       mov  rax,  qword[i]
       mov  qword [rbp-24],  rax
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword[i],  rax
       jmp  label4
label3:
       mov  qword[i],  0
label11:
       mov  rcx,  qword[i]
       cmp  rcx,  4
       jge  label14
label13:
       mov  qword [rbp-32],  1
       jmp  label15
label14:
       mov  qword [rbp-32],  0
label15:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label10
label9:
       mov  qword[j],  0
label18:
       mov  rcx,  qword[j]
       cmp  rcx,  10
       jge  label21
label20:
       mov  qword [rbp-40],  1
       jmp  label22
label21:
       mov  qword [rbp-40],  0
label22:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label17
label16:
       mov  rdx,  qword[a]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword[j]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  888
label19:
       mov  rax,  qword[j]
       mov  qword [rbp-48],  rax
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword[j],  rax
       jmp  label18
label17:
label12:
       mov  rax,  qword[i]
       mov  qword [rbp-56],  rax
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword[i],  rax
       jmp  label11
label10:
       mov  qword[i],  0
label25:
       mov  rcx,  qword[i]
       cmp  rcx,  5
       jge  label28
label27:
       mov  qword [rbp-64],  1
       jmp  label29
label28:
       mov  qword [rbp-64],  0
label29:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label24
label23:
       mov  rdi,  136
       call  malloc
       mov  qword [rbp-72],  rax
       mov  rdx,  qword [rbp-72]
       mov  rax,  qword[b]
       mov  rcx,  qword[i]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rax,  1
       neg  rax
       mov  qword [rbp-80],  rax
       mov  rbx,  qword [rbp-80]
       mov  rcx,  qword[b]
       mov  rdx,  qword[i]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 8],  rbx
label26:
       mov  rax,  qword[i]
       mov  qword [rbp-88],  rax
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword[i],  rax
       jmp  label25
label24:
       mov  rcx,  qword[a]
       mov  rax,  qword [rcx + 32]
       mov  rax,  qword [rax + 80]
       mov  rdi,  rax
       call  printNum
       mov  qword [rbp-96],  rax
       mov  qword[i],  0
label32:
       mov  rcx,  qword[i]
       cmp  rcx,  3
       jg  label35
label34:
       mov  qword [rbp-104],  1
       jmp  label36
label35:
       mov  qword [rbp-104],  0
label36:
       mov  rcx,  qword [rbp-104]
       cmp  rcx,  0
       jz  label31
label30:
       mov  qword[j],  0
label39:
       mov  rcx,  qword[j]
       cmp  rcx,  9
       jg  label42
label41:
       mov  qword [rbp-112],  1
       jmp  label43
label42:
       mov  qword [rbp-112],  0
label43:
       mov  rcx,  qword [rbp-112]
       cmp  rcx,  0
       jz  label38
label37:
       mov  rax,  qword[i]
       imul  rax,  10
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  rdx,  qword[j]
       add  rax,  rdx
       mov  qword [rbp-128],  rax
       mov  rsi,  qword [rbp-128]
       mov  rdx,  qword[a]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword[j]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rsi
label40:
       mov  rax,  qword[j]
       mov  qword [rbp-136],  rax
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword[j],  rax
       jmp  label39
label38:
label33:
       mov  rax,  qword[i]
       mov  qword [rbp-144],  rax
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword[i],  rax
       jmp  label32
label31:
       mov  qword[i],  0
label46:
       mov  rcx,  qword[i]
       cmp  rcx,  3
       jg  label49
label48:
       mov  qword [rbp-152],  1
       jmp  label50
label49:
       mov  qword [rbp-152],  0
label50:
       mov  rcx,  qword [rbp-152]
       cmp  rcx,  0
       jz  label45
label44:
       mov  qword[j],  0
label53:
       mov  rcx,  qword[j]
       cmp  rcx,  9
       jg  label56
label55:
       mov  qword [rbp-160],  1
       jmp  label57
label56:
       mov  qword [rbp-160],  0
label57:
       mov  rcx,  qword [rbp-160]
       cmp  rcx,  0
       jz  label52
label51:
       mov  rdx,  qword[a]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword[j]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  printNum
       mov  qword [rbp-168],  rax
label54:
       mov  rax,  qword[j]
       mov  qword [rbp-176],  rax
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword[j],  rax
       jmp  label53
label52:
label47:
       mov  rax,  qword[i]
       mov  qword [rbp-184],  rax
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword[i],  rax
       jmp  label46
label45:
       mov  rcx,  qword[a]
       mov  rax,  qword [rcx + 24]
       mov  qword [rax + 88],  0
       mov  rcx,  qword[a]
       mov  rax,  qword [rcx + 24]
       mov  rax,  qword [rax + 88]
       mov  rdi,  rax
       call  printNum
       mov  qword [rbp-192],  rax
       mov  rax,  2
       neg  rax
       mov  qword [rbp-200],  rax
       mov  rdx,  qword [rbp-200]
       mov  rcx,  qword[b]
       mov  rax,  qword [rcx + 8]
       mov  qword [rax + 8],  rdx
       mov  rax,  10
       neg  rax
       mov  qword [rbp-208],  rax
       mov  rdi,  qword [rbp-208]
       mov  rcx,  qword[b]
       mov  rsi,  qword[a]
       mov  rbx,  qword [rsi + 24]
       mov  rdx,  qword [rbx + 88]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 8],  rdi
       mov  rcx,  qword[b]
       mov  rax,  qword [rcx + 8]
       mov  rax,  qword [rax + 8]
       mov  rdi,  rax
       call  printNum
       mov  qword [rbp-216],  rax
       mov  rcx,  qword[b]
       mov  rax,  qword [rcx + 16]
       mov  rax,  qword [rax + 8]
       mov  rdi,  rax
       call  printNum
       mov  qword [rbp-224],  rax
       mov  rax,  0
       add  rsp,  240
       pop  rbp
       ret  
       add  rsp,  240
       pop  rbp
       ret  

section .data

section .bss

a:       resq  1
i:       resq  1
j:       resq  1
b:       resq  1


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
