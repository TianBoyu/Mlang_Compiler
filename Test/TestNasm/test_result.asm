global    open
global    origin
global    i
global    c
global    main
global    ans
global    pre
global    build
global    visit
global    f
global    closed
global    j


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

origin:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  112
       mov  qword [rbp-8],  rdi
       mov  r15,  qword [rbp-8]
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-16],  rax
       mov  r14,  qword [rbp-8]
       mov  r13,  qword [rbp-16]
       mov  qword [r13 + 0],  r14
       mov  rbx,  0
       mov  r12,  qword [rbp-16]
       mov  qword[c],  r12
       mov  qword[i],  0
       jmp  label4
label4:
       mov  r11,  qword[i]
       mov  r10,  qword [rbp-8]
       cmp  r11,  r10
       jge  label7
label6:
       mov  rbx,  1
       jmp  label8
label7:
       mov  rbx,  0
       jmp  label8
label8:
       cmp  rbx,  0
       jz  label3
label2:
       mov  r15,  qword[c]
       mov  qword [rbp-24],  r15
       mov  r14,  qword [rbp-8]
       add  r14,  1
       imul  r14,  8
       mov  rdi,  r14
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  r13,  qword [rbp-8]
       mov  qword [rbx + 0],  r13
       mov  r12,  qword [rbp-24]
       mov  r11,  qword[i]
       mov  r10,  r11
       add  r10,  1
       mov  qword [r12 + r10 * 8],  rbx
       mov  qword[j],  0
       jmp  label11
label11:
       mov  r15,  qword[j]
       mov  r14,  qword [rbp-8]
       cmp  r15,  r14
       jge  label14
label13:
       mov  rbx,  1
       jmp  label15
label14:
       mov  rbx,  0
       jmp  label15
label15:
       cmp  rbx,  0
       jz  label10
label9:
       mov  r13,  qword[c]
       mov  rbx,  r13
       mov  r12,  qword[i]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword[j]
       mov  r14,  r15
       add  r14,  1
       mov  qword [rbx + r14 * 8],  0
       jmp  label12
label12:
       mov  r13,  qword[j]
       mov  rbx,  r13
       mov  r12,  qword[j]
       mov  r11,  qword[j]
       mov  r11,  r12
       add  r11,  1
       mov  qword[j],  r11
       jmp  label11
label10:
       jmp  label5
label5:
       mov  r10,  qword[i]
       mov  rbx,  r10
       mov  r15,  qword[i]
       mov  r14,  qword[i]
       mov  r14,  r15
       add  r14,  1
       mov  qword[i],  r14
       jmp  label4
label3:
       add  rsp,  112
       pop  rbp
       ret  
       add  rsp,  112
       pop  rbp
       ret  
build:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  160
       mov  qword [rbp-8],  rdi
       mov  rbx,  rsi
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  toString
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  println
       pop  rbp
       pop  rbx
       mov  qword[i],  1
       jmp  label18
label18:
       mov  r13,  qword[i]
       cmp  r13,  49
       jg  label21
label20:
       mov  rbx,  1
       jmp  label22
label21:
       mov  rbx,  0
       jmp  label22
label22:
       cmp  rbx,  0
       jz  label17
label16:
       mov  qword[j],  50
       jmp  label25
label25:
       mov  rbx,  98
       mov  r12,  qword[i]
       mov  rbx,  rbx
       sub  rbx,  r12
       mov  rbx,  rbx
       mov  rbx,  rbx
       mov  rbx,  rbx
       add  rbx,  1
       mov  rbx,  rbx
       mov  r11,  qword[j]
       cmp  r11,  rbx
       jg  label28
label27:
       mov  rbx,  1
       jmp  label29
label28:
       mov  rbx,  0
       jmp  label29
label29:
       cmp  rbx,  0
       jz  label24
label23:
       mov  r10,  qword[c]
       mov  rbx,  r10
       mov  r15,  qword[i]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword[j]
       mov  r11,  r12
       add  r11,  1
       mov  qword [rbx + r11 * 8],  1
       jmp  label26
label26:
       mov  r10,  qword[j]
       mov  rbx,  r10
       mov  r15,  qword[j]
       mov  r14,  qword[j]
       mov  r14,  r15
       add  r14,  1
       mov  qword[j],  r14
       jmp  label25
label24:
       jmp  label19
label19:
       mov  r13,  qword[i]
       mov  rbx,  r13
       mov  r12,  qword[i]
       mov  r11,  qword[i]
       mov  r11,  r12
       add  r11,  1
       mov  qword[i],  r11
       jmp  label18
label17:
       mov  qword[i],  1
       jmp  label32
label32:
       mov  r10,  qword[i]
       cmp  r10,  49
       jg  label35
label34:
       mov  rbx,  1
       jmp  label36
label35:
       mov  rbx,  0
       jmp  label36
label36:
       cmp  rbx,  0
       jz  label31
label30:
       mov  r15,  qword[c]
       mov  rbx,  r15
       mov  r14,  qword [rbp-8]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword[i]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  1
       jmp  label33
label33:
       mov  r15,  qword[i]
       mov  rbx,  r15
       mov  r14,  qword[i]
       mov  r13,  qword[i]
       mov  r13,  r14
       add  r13,  1
       mov  qword[i],  r13
       jmp  label32
label31:
       mov  qword[i],  50
       jmp  label39
label39:
       mov  r12,  qword[i]
       cmp  r12,  98
       jg  label42
label41:
       mov  rbx,  1
       jmp  label43
label42:
       mov  rbx,  0
       jmp  label43
label43:
       cmp  rbx,  0
       jz  label38
label37:
       mov  rax,  0
       add  rsp,  160
       pop  rbp
       ret  
       jmp  label40
label40:
       mov  r11,  qword[i]
       mov  rbx,  r11
       mov  r10,  qword[i]
       mov  r15,  qword[i]
       mov  r15,  r10
       add  r15,  1
       mov  qword[i],  r15
       jmp  label39
label38:
       add  rsp,  160
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  rdi,  888
       call  malloc
       mov  qword [rbp-8],  rax
       mov  r15,  qword [rbp-8]
       mov  qword [r15 + 0],  110
       mov  r14,  qword [rbp-8]
       mov  qword[visit],  r14
       mov  rdi,  888
       call  malloc
       mov  qword [rbp-16],  rax
       mov  r13,  qword [rbp-16]
       mov  qword [r13 + 0],  110
       mov  r12,  qword [rbp-16]
       mov  qword[pre],  r12
       mov  rdi,  888
       call  malloc
       mov  qword [rbp-24],  rax
       mov  r11,  qword [rbp-24]
       mov  qword [r11 + 0],  110
       mov  r10,  qword [rbp-24]
       mov  qword[f],  r10
       push  rbx
       push  rbp
       mov  rdi,  String_0
       call  println
       pop  rbp
       pop  rbx
       push  rbx
       push  rbp
       mov  rdi,  110
       call  origin
       pop  rbp
       pop  rbx
       push  rbx
       push  rbp
       mov  rdi,  String_1
       call  println
       pop  rbp
       pop  rbx
       mov  rbx,  0
       mov  rbx,  99
       mov  qword [rbp-8],  100
       mov  qword [rbp-16],  0
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-8]
       call  toString
       pop  rbp
       pop  rbx
       mov  qword [rbp-24],  rax
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-24]
       call  println
       pop  rbp
       pop  rbx
       push  rbx
       push  rbp
       mov  rdi,  rbx
       mov  rsi,  qword [rbp-8]
       call  build
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  rax,  0
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  

section .data
       dq  4
String_0:
       db  104, 104, 104, 104, 0
       dq  4
String_1:
       db  113, 113, 113, 113, 0
ans:
       dq  0

section .bss

c:       resq  1
visit:       resq  1
pre:       resq  1
f:       resq  1
i:       resq  1
j:       resq  1
open:       resq  1
closed:       resq  1


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
