global    step
global    now
global    x
global    dx
global    tail
global    targety
global    y
global    i
global    main
global    ok
global    origin
global    N
global    xlist
global    j
global    dy
global    check
global    starty
global    startx
global    targetx
global    ylist
global    addList
global    head


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
       sub  rsp,  80
       mov  qword [rbp-8],  rdi
       mov  qword[head],  0
       mov  qword[tail],  0
       mov  rcx,  qword [rbp-8]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rcx,  qword [rbp-8]
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  rcx
       mov  qword [rbp-24],  0
       mov  rax,  qword [rbp-16]
       mov  qword[step],  rax
       mov  qword[i],  0
label4:
       mov  rcx,  qword[i]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label7
label6:
       mov  qword [rbp-32],  1
       jmp  label8
label7:
       mov  qword [rbp-32],  0
label8:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label3
label2:
       mov  rcx,  qword [rbp-8]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-40],  rax
       mov  rcx,  qword [rbp-8]
       mov  rax,  qword [rbp-40]
       mov  qword [rax + 0],  rcx
       mov  rdx,  qword [rbp-40]
       mov  rax,  qword[step]
       mov  rcx,  qword[i]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  qword[j],  0
label11:
       mov  rcx,  qword[j]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label14
label13:
       mov  qword [rbp-48],  1
       jmp  label15
label14:
       mov  qword [rbp-48],  0
label15:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jz  label10
label9:
       mov  rdx,  qword[step]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword[j]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  0
label12:
       mov  rax,  qword[j]
       mov  qword [rbp-56],  rax
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword[j],  rax
       jmp  label11
label10:
label5:
       mov  rax,  qword[i]
       mov  qword [rbp-64],  rax
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword[i],  rax
       jmp  label4
label3:
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
check:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  48
       mov  qword [rbp-8],  rdi
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jge  label22
label21:
       mov  qword [rbp-16],  1
       jmp  label23
label22:
       mov  qword [rbp-16],  0
label23:
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jz  label19
label16:
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  0
       jl  label25
label24:
       mov  qword [rbp-24],  1
       jmp  label26
label25:
       mov  qword [rbp-24],  0
label26:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label19
label18:
       mov  qword [rbp-32],  1
       jmp  label20
label19:
       mov  qword [rbp-32],  0
label20:
       mov  rax,  qword [rbp-32]
       add  rsp,  48
       pop  rbp
       ret  
       add  rsp,  48
       pop  rbp
       ret  
addList:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  128
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  check
       mov  qword [rbp-24],  rax
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label38
label35:
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  check
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label38
label37:
       mov  qword [rbp-40],  1
       jmp  label39
label38:
       mov  qword [rbp-40],  0
label39:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label33
label30:
       mov  rax,  1
       neg  rax
       mov  qword [rbp-48],  rax
       mov  rbx,  qword[step]
       mov  rsi,  qword [rbp-8]
       add  rsi,  1
       mov  rcx,  qword [rbx + rsi * 8]
       mov  rdx,  qword [rbp-16]
       add  rdx,  1
       mov  rdi,  qword [rcx + rdx * 8]
       mov  r8,  qword [rbp-48]
       cmp  rdi,  r8
       jne  label41
label40:
       mov  qword [rbp-56],  1
       jmp  label42
label41:
       mov  qword [rbp-56],  0
label42:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label33
label32:
       mov  qword [rbp-64],  1
       jmp  label34
label33:
       mov  qword [rbp-64],  0
label34:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label28
label27:
       mov  rax,  qword[tail]
       mov  qword [rbp-72],  rax
       mov  rax,  qword[tail]
       add  rax,  1
       mov  qword[tail],  rax
       mov  rdx,  qword [rbp-8]
       mov  rax,  qword[xlist]
       mov  rcx,  qword[tail]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rdx,  qword [rbp-16]
       mov  rax,  qword[ylist]
       mov  rcx,  qword[tail]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rax,  qword[now]
       add  rax,  1
       mov  qword [rbp-80],  rax
       mov  rsi,  qword [rbp-80]
       mov  rdx,  qword[step]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-16]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rsi
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword[targetx]
       cmp  rcx,  rdx
       jne  label52
label51:
       mov  qword [rbp-88],  1
       jmp  label53
label52:
       mov  qword [rbp-88],  0
label53:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  0
       jz  label49
label46:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword[targety]
       cmp  rcx,  rdx
       jne  label55
label54:
       mov  qword [rbp-96],  1
       jmp  label56
label55:
       mov  qword [rbp-96],  0
label56:
       mov  rcx,  qword [rbp-96]
       cmp  rcx,  0
       jz  label49
label48:
       mov  qword [rbp-104],  1
       jmp  label50
label49:
       mov  qword [rbp-104],  0
label50:
       mov  rcx,  qword [rbp-104]
       cmp  rcx,  0
       jz  label44
label43:
       mov  qword[ok],  1
       jmp  label45
label44:
       jmp  label45
label45:
       jmp  label29
label28:
       jmp  label29
label29:
       add  rsp,  128
       pop  rbp
       ret  
       add  rsp,  128
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  208
       mov  rdi,  96008
       call  malloc
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword [rax + 0],  12000
       mov  rax,  qword [rbp-8]
       mov  qword[xlist],  rax
       mov  rdi,  96008
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  12000
       mov  rax,  qword [rbp-16]
       mov  qword[ylist],  rax
       mov  rdi,  72
       call  malloc
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rax + 0],  8
       mov  rax,  qword [rbp-24]
       mov  qword[dx],  rax
       mov  rdi,  80
       call  malloc
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword [rax + 0],  9
       mov  rax,  qword [rbp-32]
       mov  qword[dy],  rax
       mov  rdi,  106
       call  origin
       call  getInt
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword[N],  rax
       mov  rax,  qword[N]
       sub  rax,  1
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword[targety],  rax
       mov  rax,  qword[targety]
       mov  qword[targetx],  rax
       mov  qword[i],  0
label59:
       mov  rcx,  qword[i]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jge  label62
label61:
       mov  qword [rbp-24],  1
       jmp  label63
label62:
       mov  qword [rbp-24],  0
label63:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label58
label57:
       mov  qword[j],  0
label66:
       mov  rcx,  qword[j]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jge  label69
label68:
       mov  qword [rbp-32],  1
       jmp  label70
label69:
       mov  qword [rbp-32],  0
label70:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label65
label64:
       mov  rax,  1
       neg  rax
       mov  qword [rbp-40],  rax
       mov  rsi,  qword [rbp-40]
       mov  rdx,  qword[step]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword[j]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rsi
label67:
       mov  rax,  qword[j]
       mov  qword [rbp-48],  rax
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword[j],  rax
       jmp  label66
label65:
label60:
       mov  rax,  qword[i]
       mov  qword [rbp-56],  rax
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword[i],  rax
       jmp  label59
label58:
       mov  rax,  2
       neg  rax
       mov  qword [rbp-64],  rax
       mov  rcx,  qword [rbp-64]
       mov  rax,  qword[dx]
       mov  qword [rax + 8],  rcx
       mov  rax,  1
       neg  rax
       mov  qword [rbp-72],  rax
       mov  rcx,  qword [rbp-72]
       mov  rax,  qword[dy]
       mov  qword [rax + 8],  rcx
       mov  rax,  2
       neg  rax
       mov  qword [rbp-80],  rax
       mov  rcx,  qword [rbp-80]
       mov  rax,  qword[dx]
       mov  qword [rax + 16],  rcx
       mov  rax,  qword[dy]
       mov  qword [rax + 16],  1
       mov  rax,  qword[dx]
       mov  qword [rax + 24],  2
       mov  rax,  1
       neg  rax
       mov  qword [rbp-88],  rax
       mov  rcx,  qword [rbp-88]
       mov  rax,  qword[dy]
       mov  qword [rax + 24],  rcx
       mov  rax,  qword[dx]
       mov  qword [rax + 32],  2
       mov  rax,  qword[dy]
       mov  qword [rax + 32],  1
       mov  rax,  1
       neg  rax
       mov  qword [rbp-96],  rax
       mov  rcx,  qword [rbp-96]
       mov  rax,  qword[dx]
       mov  qword [rax + 40],  rcx
       mov  rax,  2
       neg  rax
       mov  qword [rbp-104],  rax
       mov  rcx,  qword [rbp-104]
       mov  rax,  qword[dy]
       mov  qword [rax + 40],  rcx
       mov  rax,  1
       neg  rax
       mov  qword [rbp-112],  rax
       mov  rcx,  qword [rbp-112]
       mov  rax,  qword[dx]
       mov  qword [rax + 48],  rcx
       mov  rax,  qword[dy]
       mov  qword [rax + 48],  2
       mov  rax,  qword[dx]
       mov  qword [rax + 56],  1
       mov  rax,  2
       neg  rax
       mov  qword [rbp-120],  rax
       mov  rcx,  qword [rbp-120]
       mov  rax,  qword[dy]
       mov  qword [rax + 56],  rcx
       mov  rax,  qword[dx]
       mov  qword [rax + 64],  1
       mov  rax,  qword[dy]
       mov  qword [rax + 64],  2
label73:
       mov  rcx,  qword[head]
       mov  rdx,  qword[tail]
       cmp  rcx,  rdx
       jg  label75
label74:
       mov  qword [rbp-128],  1
       jmp  label76
label75:
       mov  qword [rbp-128],  0
label76:
       mov  rcx,  qword [rbp-128]
       cmp  rcx,  0
       jz  label72
label71:
       mov  rax,  qword[xlist]
       mov  rcx,  qword[head]
       add  rcx,  1
       mov  rdx,  qword [rax + rcx * 8]
       mov  qword[x],  rdx
       mov  rax,  qword[ylist]
       mov  rcx,  qword[head]
       add  rcx,  1
       mov  rdx,  qword [rax + rcx * 8]
       mov  qword[y],  rdx
       mov  rdx,  qword[step]
       mov  rbx,  qword[x]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword[y]
       add  rcx,  1
       mov  rsi,  qword [rax + rcx * 8]
       mov  qword[now],  rsi
       mov  qword[j],  0
label79:
       mov  rcx,  qword[j]
       cmp  rcx,  8
       jge  label82
label81:
       mov  qword [rbp-136],  1
       jmp  label83
label82:
       mov  qword [rbp-136],  0
label83:
       mov  rcx,  qword [rbp-136]
       cmp  rcx,  0
       jz  label78
label77:
       mov  rax,  qword[x]
       mov  rdx,  qword[dx]
       mov  rbx,  qword[j]
       add  rbx,  1
       mov  rsi,  qword [rdx + rbx * 8]
       add  rax,  rsi
       mov  qword [rbp-144],  rax
       mov  rax,  qword[y]
       mov  rdx,  qword[dy]
       mov  rbx,  qword[j]
       add  rbx,  1
       mov  rsi,  qword [rdx + rbx * 8]
       add  rax,  rsi
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-144]
       mov  rdi,  rax
       mov  rax,  qword [rbp-152]
       mov  rsi,  rax
       call  addList
label80:
       mov  rax,  qword[j]
       mov  qword [rbp-160],  rax
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword[j],  rax
       jmp  label79
label78:
       mov  rcx,  qword[ok]
       cmp  rcx,  1
       jne  label88
label87:
       mov  qword [rbp-168],  1
       jmp  label89
label88:
       mov  qword [rbp-168],  0
label89:
       mov  rcx,  qword [rbp-168]
       cmp  rcx,  0
       jz  label85
label84:
       jmp  label72
       jmp  label86
label85:
       jmp  label86
label86:
       mov  rax,  qword[head]
       mov  qword [rbp-176],  rax
       mov  rax,  qword[head]
       add  rax,  1
       mov  qword[head],  rax
       jmp  label73
label72:
       mov  rcx,  qword[ok]
       cmp  rcx,  1
       jne  label94
label93:
       mov  qword [rbp-184],  1
       jmp  label95
label94:
       mov  qword [rbp-184],  0
label95:
       mov  rcx,  qword [rbp-184]
       cmp  rcx,  0
       jz  label91
label90:
       mov  rdx,  qword[step]
       mov  rbx,  qword[targetx]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword[targety]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-192]
       mov  rdi,  rax
       call  println
       jmp  label92
label91:
       mov  rax,  String_0
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-200]
       mov  rdi,  rax
       call  print
       jmp  label92
label92:
       mov  rax,  0
       add  rsp,  208
       pop  rbp
       ret  
       add  rsp,  208
       pop  rbp
       ret  

section .data
       dq  13
String_0:
       db  110, 111, 32, 115, 111, 108, 117, 116, 105, 111, 110, 33, 10, 0

section .bss

N:       resq  1
head:       resq  1
startx:       resq  1
starty:       resq  1
targetx:       resq  1
targety:       resq  1
x:       resq  1
y:       resq  1
xlist:       resq  1
ylist:       resq  1
tail:       resq  1
ok:       resq  1
now:       resq  1
dx:       resq  1
dy:       resq  1
step:       resq  1
i:       resq  1
j:       resq  1


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
