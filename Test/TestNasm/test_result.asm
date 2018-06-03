global    t
global    pushdown
global    p
global    Rand
global    RandRange
global    no
global    pr
global    ans
global    aa
global    n
global    update
global    now
global    gcd
global    L
global    MOD
global    a
global    bb
global    build
global    query
global    lcm
global    init
global    s
global    pl
global    main
global    square
global    flag
global    op
global    b
global    m
global    sum


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

square:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  48
       mov  qword [rbp-8],  rdi
       mov  rax,  qword [rbp-8]
       mov  rdx,  rax
       mov  rcx,  qword[p]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-16],  rdx
       mov  rax,  qword [rbp-8]
       mov  rdx,  rax
       mov  rcx,  qword[p]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-24],  rdx
       mov  rax,  qword [rbp-16]
       mov  rdx,  qword [rbp-24]
       imul  rax,  rdx
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       add  rsp,  48
       pop  rbp
       ret  
       add  rsp,  48
       pop  rbp
       ret  
gcd:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jne  label8
label7:
       mov  qword [rbp-24],  1
       jmp  label9
label8:
       mov  qword [rbp-24],  0
label9:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label5
label4:
       mov  rax,  qword [rbp-8]
       add  rsp,  80
       pop  rbp
       ret  
       jmp  label6
label5:
       jmp  label6
label6:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-16]
       cmp  rcx,  rdx
       jge  label14
label13:
       mov  qword [rbp-32],  1
       jmp  label15
label14:
       mov  qword [rbp-32],  0
label15:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label11
label10:
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  gcd
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       add  rsp,  80
       pop  rbp
       ret  
       jmp  label12
label11:
       mov  rax,  qword [rbp-8]
       mov  rdx,  rax
       mov  rcx,  qword [rbp-16]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-56],  rdx
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       mov  rax,  qword [rbp-56]
       mov  rsi,  rax
       call  gcd
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       add  rsp,  80
       pop  rbp
       ret  
       jmp  label12
label12:
       add  rsp,  80
       pop  rbp
       ret  
lcm:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  64
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       call  gcd
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-8]
       mov  rcx,  qword [rbp-24]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  rdx,  qword [rbp-16]
       imul  rax,  rdx
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       add  rsp,  64
       pop  rbp
       ret  
       add  rsp,  64
       pop  rbp
       ret  
Rand:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  qword [rbp-8],  1
       mov  qword [rbp-8],  1
label18:
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  3
       jge  label21
label20:
       mov  qword [rbp-16],  1
       jmp  label22
label21:
       mov  qword [rbp-16],  0
label22:
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jz  label17
label16:
       mov  rax,  qword[no]
       mov  rdx,  qword[aa]
       imul  rax,  rdx
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  rdx,  qword[bb]
       add  rax,  rdx
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  rdx,  rax
       mov  rcx,  qword[MOD]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-40],  rdx
       mov  rax,  qword [rbp-40]
       mov  qword[no],  rax
label19:
       mov  rax,  qword [rbp-8]
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-8]
       add  rax,  1
       mov  qword [rbp-8],  rax
       jmp  label18
label17:
       mov  rcx,  qword[no]
       cmp  rcx,  0
       jge  label27
label26:
       mov  qword [rbp-56],  1
       jmp  label28
label27:
       mov  qword [rbp-56],  0
label28:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label24
label23:
       mov  rax,  qword[no]
       neg  rax
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  qword[no],  rax
       jmp  label25
label24:
       jmp  label25
label25:
       mov  rax,  qword[no]
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
RandRange:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       call  Rand
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-16]
       mov  rdx,  qword [rbp-8]
       sub  rax,  rdx
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-24]
       mov  rdx,  rax
       mov  rcx,  qword [rbp-40]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-48],  rdx
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-48]
       add  rax,  rdx
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       add  rax,  1
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
init:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  144
       mov  rdi,  1120048
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  140005
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-8],  rax
       mov  qword [rbp-24],  0
       mov  qword [rbp-32],  0
       mov  qword [rbp-24],  2
label31:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[p]
       cmp  rcx,  rdx
       jge  label34
label33:
       mov  qword [rbp-40],  1
       jmp  label35
label34:
       mov  qword [rbp-40],  0
label35:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label30
label29:
       mov  rdx,  qword [rbp-24]
       mov  rax,  qword [rbp-8]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
label32:
       mov  rax,  qword [rbp-24]
       add  rax,  1
       mov  qword [rbp-24],  rax
       jmp  label31
label30:
       mov  qword [rbp-24],  2
label38:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[p]
       cmp  rcx,  rdx
       jge  label41
label40:
       mov  qword [rbp-48],  1
       jmp  label42
label41:
       mov  qword [rbp-48],  0
label42:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jz  label37
label36:
       mov  qword [rbp-32],  1
label45:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  15
       jg  label48
label47:
       mov  qword [rbp-56],  1
       jmp  label49
label48:
       mov  qword [rbp-56],  0
label49:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label44
label43:
       mov  rax,  qword [rbp-8]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  square
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  rdx,  rax
       mov  rcx,  qword[p]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-72],  rdx
       mov  rdx,  qword [rbp-72]
       mov  rax,  qword [rbp-8]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
label46:
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       jmp  label45
label44:
label39:
       mov  rax,  qword [rbp-24]
       add  rax,  1
       mov  qword [rbp-24],  rax
       jmp  label38
label37:
       mov  qword [rbp-24],  2
label52:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[p]
       cmp  rcx,  rdx
       jge  label55
label54:
       mov  qword [rbp-80],  1
       jmp  label56
label55:
       mov  qword [rbp-80],  0
label56:
       mov  rcx,  qword [rbp-80]
       cmp  rcx,  0
       jz  label51
label50:
       mov  rax,  qword [rbp-8]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  rdx,  qword [rax + rcx * 8]
       mov  qword [rbp-96],  rdx
       mov  qword [rbp-88],  1
label59:
label57:
       mov  rax,  qword [rbp-96]
       mov  rdi,  rax
       call  square
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  rdx,  rax
       mov  rcx,  qword[p]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-112],  rdx
       mov  rax,  qword [rbp-112]
       mov  qword [rbp-96],  rax
       mov  rax,  qword[b]
       mov  rcx,  qword [rbp-96]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  1
       mov  rcx,  qword [rbp-96]
       mov  rdx,  qword [rbp-8]
       mov  rbx,  qword [rbp-24]
       add  rbx,  1
       mov  r8,  qword [rdx + rbx * 8]
       cmp  rcx,  r8
       jne  label65
label64:
       mov  qword [rbp-120],  1
       jmp  label66
label65:
       mov  qword [rbp-120],  0
label66:
       mov  rcx,  qword [rbp-120]
       cmp  rcx,  0
       jz  label62
label61:
       jmp  label58
       jmp  label63
label62:
       jmp  label63
label63:
label60:
       mov  rax,  qword [rbp-88]
       add  rax,  1
       mov  qword [rbp-88],  rax
       jmp  label59
label58:
       mov  rax,  qword[L]
       mov  rdi,  rax
       mov  rax,  qword [rbp-88]
       mov  rsi,  rax
       call  lcm
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-128]
       mov  qword[L],  rax
label53:
       mov  rax,  qword [rbp-24]
       add  rax,  1
       mov  qword [rbp-24],  rax
       jmp  label52
label51:
       mov  rax,  qword[b]
       mov  qword [rax + 8],  1
       mov  rax,  qword[b]
       mov  qword [rax + 16],  1
       add  rsp,  144
       pop  rbp
       ret  
       add  rsp,  144
       pop  rbp
       ret  
build:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  256
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  rdx
       mov  qword [rbp-32],  0
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       jne  label71
label70:
       mov  qword [rbp-40],  1
       jmp  label72
label71:
       mov  qword [rbp-40],  0
label72:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label68
label67:
       mov  rdx,  qword[a]
       mov  rbx,  qword [rbp-16]
       add  rbx,  1
       mov  r8,  qword [rdx + rbx * 8]
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
       mov  rcx,  qword[a]
       mov  rdx,  qword [rbp-16]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       mov  r8,  qword[p]
       cmp  rbx,  r8
       jge  label87
label86:
       mov  qword [rbp-48],  1
       jmp  label88
label87:
       mov  qword [rbp-48],  0
label88:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jz  label84
label81:
       mov  rcx,  qword[a]
       mov  rdx,  qword [rbp-16]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jl  label90
label89:
       mov  qword [rbp-56],  1
       jmp  label91
label90:
       mov  qword [rbp-56],  0
label91:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label84
label83:
       mov  qword [rbp-64],  1
       jmp  label85
label84:
       mov  qword [rbp-64],  0
label85:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label79
label76:
       mov  rcx,  qword[a]
       mov  rbx,  qword [rbp-16]
       add  rbx,  1
       mov  rax,  qword [rcx + rbx * 8]
       mov  rdx,  rax
       mov  r8,  qword[p]
       mov  rdx,  0
       idiv  r8
       mov  qword [rbp-72],  rdx
       mov  rcx,  qword[b]
       mov  rdx,  qword [rbp-72]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jle  label93
label92:
       mov  qword [rbp-80],  1
       jmp  label94
label93:
       mov  qword [rbp-80],  0
label94:
       mov  rcx,  qword [rbp-80]
       cmp  rcx,  0
       jz  label79
label78:
       mov  qword [rbp-88],  1
       jmp  label80
label79:
       mov  qword [rbp-88],  0
label80:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  0
       jz  label74
label73:
       mov  rax,  qword[flag]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  1
       mov  rbx,  qword[a]
       mov  r8,  qword [rbp-16]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rcx,  qword[s]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 8],  r9
       mov  qword [rbp-32],  1
label97:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[L]
       cmp  rcx,  rdx
       jge  label100
label99:
       mov  qword [rbp-96],  1
       jmp  label101
label100:
       mov  qword [rbp-96],  0
label101:
       mov  rcx,  qword [rbp-96]
       cmp  rcx,  0
       jz  label96
label95:
       mov  rax,  qword [rbp-32]
       sub  rax,  1
       mov  qword [rbp-112],  rax
       mov  rdx,  qword[s]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-112]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  square
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  rdx,  rax
       mov  rcx,  qword[p]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-120],  rdx
       mov  r8,  qword [rbp-120]
       mov  rdx,  qword[s]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-32]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
label98:
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       jmp  label97
label96:
       jmp  label75
label74:
       jmp  label75
label75:
       mov  rax,  qword[now]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  0
       jmp  label69
label68:
       mov  rax,  qword [rbp-8]
       imul  rax,  2
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-8]
       imul  rax,  2
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       add  rax,  1
       mov  qword [rbp-160],  rax
       mov  rax,  qword [rbp-160]
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-16]
       mov  rdx,  qword [rbp-24]
       add  rax,  rdx
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-176]
       mov  rcx,  2
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-184]
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-128]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       mov  rax,  qword [rbp-168]
       mov  rdx,  rax
       call  build
       mov  rax,  qword [rbp-168]
       add  rax,  1
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-144]
       mov  rdi,  rax
       mov  rax,  qword [rbp-192]
       mov  rsi,  rax
       mov  rax,  qword [rbp-24]
       mov  rdx,  rax
       call  build
       mov  rcx,  qword[sum]
       mov  rdx,  qword [rbp-128]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword[sum]
       mov  r9,  qword [rbp-144]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       add  rax,  r10
       mov  qword [rbp-200],  rax
       mov  rdx,  qword [rbp-200]
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rcx,  qword[flag]
       mov  rdx,  qword [rbp-128]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword[flag]
       mov  r9,  qword [rbp-144]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       and  rax,  r10
       mov  qword [rbp-208],  rax
       mov  rdx,  qword [rbp-208]
       mov  rax,  qword[flag]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rcx,  qword[flag]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jle  label106
label105:
       mov  qword [rbp-216],  1
       jmp  label107
label106:
       mov  qword [rbp-216],  0
label107:
       mov  rcx,  qword [rbp-216]
       cmp  rcx,  0
       jz  label103
label102:
       mov  qword [rbp-32],  0
label110:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[L]
       cmp  rcx,  rdx
       jge  label113
label112:
       mov  qword [rbp-224],  1
       jmp  label114
label113:
       mov  qword [rbp-224],  0
label114:
       mov  rcx,  qword [rbp-224]
       cmp  rcx,  0
       jz  label109
label108:
       mov  rbx,  qword[s]
       mov  r8,  qword [rbp-128]
       add  r8,  1
       mov  rcx,  qword [rbx + r8 * 8]
       mov  rdx,  qword [rbp-32]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r12,  qword[s]
       mov  r13,  qword [rbp-144]
       add  r13,  1
       mov  r10,  qword [r12 + r13 * 8]
       mov  r11,  qword [rbp-32]
       add  r11,  1
       mov  r14,  qword [r10 + r11 * 8]
       add  rax,  r14
       mov  qword [rbp-232],  rax
       mov  r8,  qword [rbp-232]
       mov  rdx,  qword[s]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-32]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
label111:
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       jmp  label110
label109:
       mov  rax,  qword[now]
       mov  qword [rax + 8],  0
       jmp  label104
label103:
       jmp  label104
label104:
       jmp  label69
label69:
       add  rsp,  256
       pop  rbp
       ret  
       add  rsp,  256
       pop  rbp
       ret  
pushdown:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  144
       mov  qword [rbp-8],  rdi
       mov  rcx,  qword[t]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jle  label119
label118:
       mov  qword [rbp-16],  1
       jmp  label120
label119:
       mov  qword [rbp-16],  0
label120:
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jz  label116
label115:
       mov  rax,  qword [rbp-8]
       imul  rax,  2
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-8]
       imul  rax,  2
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       add  rax,  1
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  qword [rbp-40],  rax
       mov  rcx,  qword[now]
       mov  rdx,  qword [rbp-24]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword[t]
       mov  r9,  qword [rbp-8]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       add  rax,  r10
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  rdx,  rax
       mov  rcx,  qword[L]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-72],  rdx
       mov  rdx,  qword [rbp-72]
       mov  rax,  qword[now]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  r8,  qword[s]
       mov  r9,  qword [rbp-24]
       add  r9,  1
       mov  rdx,  qword [r8 + r9 * 8]
       mov  r10,  qword[now]
       mov  r11,  qword [rbp-24]
       add  r11,  1
       mov  rbx,  qword [r10 + r11 * 8]
       add  rbx,  1
       mov  r12,  qword [rdx + rbx * 8]
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r12
       mov  rcx,  qword[t]
       mov  rdx,  qword [rbp-24]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword[t]
       mov  r9,  qword [rbp-8]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       add  rax,  r10
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  rdx,  rax
       mov  rcx,  qword[L]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-88],  rdx
       mov  rdx,  qword [rbp-88]
       mov  rax,  qword[t]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rcx,  qword[now]
       mov  rdx,  qword [rbp-40]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword[t]
       mov  r9,  qword [rbp-8]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       add  rax,  r10
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       mov  rdx,  rax
       mov  rcx,  qword[L]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-104],  rdx
       mov  rdx,  qword [rbp-104]
       mov  rax,  qword[now]
       mov  rcx,  qword [rbp-40]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  r8,  qword[s]
       mov  r9,  qword [rbp-40]
       add  r9,  1
       mov  rdx,  qword [r8 + r9 * 8]
       mov  r10,  qword[now]
       mov  r11,  qword [rbp-40]
       add  r11,  1
       mov  rbx,  qword [r10 + r11 * 8]
       add  rbx,  1
       mov  r12,  qword [rdx + rbx * 8]
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-40]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r12
       mov  rcx,  qword[t]
       mov  rdx,  qword [rbp-40]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword[t]
       mov  r9,  qword [rbp-8]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       add  rax,  r10
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       mov  rdx,  rax
       mov  rcx,  qword[L]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-120],  rdx
       mov  rdx,  qword [rbp-120]
       mov  rax,  qword[t]
       mov  rcx,  qword [rbp-40]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rax,  qword[t]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  0
       jmp  label117
label116:
       jmp  label117
label117:
       add  rsp,  144
       pop  rbp
       ret  
       add  rsp,  144
       pop  rbp
       ret  
update:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  368
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  rdx
       mov  rcx,  qword[pl]
       mov  rdx,  qword [rbp-16]
       cmp  rcx,  rdx
       jg  label135
label134:
       mov  qword [rbp-32],  1
       jmp  label136
label135:
       mov  qword [rbp-32],  0
label136:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label132
label129:
       mov  rcx,  qword[pr]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       jl  label138
label137:
       mov  qword [rbp-40],  1
       jmp  label139
label138:
       mov  qword [rbp-40],  0
label139:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label132
label131:
       mov  qword [rbp-48],  1
       jmp  label133
label132:
       mov  qword [rbp-48],  0
label133:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jz  label127
label124:
       mov  rcx,  qword[flag]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jle  label141
label140:
       mov  qword [rbp-56],  1
       jmp  label142
label141:
       mov  qword [rbp-56],  0
label142:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label127
label126:
       mov  qword [rbp-64],  1
       jmp  label128
label127:
       mov  qword [rbp-64],  0
label128:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label122
label121:
       mov  rcx,  qword[now]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       add  rax,  1
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-72]
       mov  rdx,  rax
       mov  rcx,  qword[L]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-80],  rdx
       mov  rdx,  qword [rbp-80]
       mov  rax,  qword[now]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  r8,  qword[s]
       mov  r9,  qword [rbp-8]
       add  r9,  1
       mov  rdx,  qword [r8 + r9 * 8]
       mov  r10,  qword[now]
       mov  r11,  qword [rbp-8]
       add  r11,  1
       mov  rbx,  qword [r10 + r11 * 8]
       add  rbx,  1
       mov  r12,  qword [rdx + rbx * 8]
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r12
       mov  rcx,  qword[t]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       add  rax,  1
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  rdx,  rax
       mov  rcx,  qword[L]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-96],  rdx
       mov  rdx,  qword [rbp-96]
       mov  rax,  qword[t]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       add  rsp,  368
       pop  rbp
       ret  
       jmp  label123
label122:
       jmp  label123
label123:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       jne  label147
label146:
       mov  qword [rbp-104],  1
       jmp  label148
label147:
       mov  qword [rbp-104],  0
label148:
       mov  rcx,  qword [rbp-104]
       cmp  rcx,  0
       jz  label144
label143:
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  square
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       mov  rdx,  rax
       mov  rcx,  qword[p]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-120],  rdx
       mov  rdx,  qword [rbp-120]
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rcx,  qword[b]
       mov  rbx,  qword[sum]
       mov  r8,  qword [rbp-8]
       add  r8,  1
       mov  rdx,  qword [rbx + r8 * 8]
       add  rdx,  1
       mov  r9,  qword [rcx + rdx * 8]
       cmp  r9,  0
       jle  label153
label152:
       mov  qword [rbp-128],  1
       jmp  label154
label153:
       mov  qword [rbp-128],  0
label154:
       mov  rcx,  qword [rbp-128]
       cmp  rcx,  0
       jz  label150
label149:
       mov  rax,  qword[flag]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  1
       mov  rbx,  qword[sum]
       mov  r8,  qword [rbp-8]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rcx,  qword[s]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 8],  r9
       mov  qword [rbp-136],  0
       mov  qword [rbp-136],  1
label157:
       mov  rcx,  qword [rbp-136]
       mov  rdx,  qword[L]
       cmp  rcx,  rdx
       jge  label160
label159:
       mov  qword [rbp-144],  1
       jmp  label161
label160:
       mov  qword [rbp-144],  0
label161:
       mov  rcx,  qword [rbp-144]
       cmp  rcx,  0
       jz  label156
label155:
       mov  rax,  qword [rbp-136]
       sub  rax,  1
       mov  qword [rbp-160],  rax
       mov  rdx,  qword[s]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-160]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  square
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       mov  rdx,  rax
       mov  rcx,  qword[p]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-168],  rdx
       mov  r8,  qword [rbp-168]
       mov  rdx,  qword[s]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-136]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
label158:
       mov  rax,  qword [rbp-136]
       add  rax,  1
       mov  qword [rbp-136],  rax
       jmp  label157
label156:
       jmp  label151
label150:
       jmp  label151
label151:
       add  rsp,  368
       pop  rbp
       ret  
       jmp  label145
label144:
       jmp  label145
label145:
       mov  rcx,  qword[t]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jle  label166
label165:
       mov  qword [rbp-176],  1
       jmp  label167
label166:
       mov  qword [rbp-176],  0
label167:
       mov  rcx,  qword [rbp-176]
       cmp  rcx,  0
       jz  label163
label162:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  pushdown
       jmp  label164
label163:
       jmp  label164
label164:
       mov  rax,  qword [rbp-8]
       imul  rax,  2
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-192]
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-8]
       imul  rax,  2
       mov  qword [rbp-208],  rax
       mov  rax,  qword [rbp-208]
       add  rax,  1
       mov  qword [rbp-216],  rax
       mov  rax,  qword [rbp-216]
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-16]
       mov  rdx,  qword [rbp-24]
       add  rax,  rdx
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-232]
       mov  rcx,  2
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-240],  rax
       mov  rax,  qword [rbp-240]
       mov  qword [rbp-224],  rax
       mov  rcx,  qword[pl]
       mov  rdx,  qword [rbp-224]
       cmp  rcx,  rdx
       jg  label172
label171:
       mov  qword [rbp-248],  1
       jmp  label173
label172:
       mov  qword [rbp-248],  0
label173:
       mov  rcx,  qword [rbp-248]
       cmp  rcx,  0
       jz  label169
label168:
       mov  rax,  qword [rbp-184]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       mov  rax,  qword [rbp-224]
       mov  rdx,  rax
       call  update
       jmp  label170
label169:
       jmp  label170
label170:
       mov  rax,  qword [rbp-224]
       add  rax,  1
       mov  qword [rbp-256],  rax
       mov  rcx,  qword[pr]
       mov  rdx,  qword [rbp-256]
       cmp  rcx,  rdx
       jl  label178
label177:
       mov  qword [rbp-264],  1
       jmp  label179
label178:
       mov  qword [rbp-264],  0
label179:
       mov  rcx,  qword [rbp-264]
       cmp  rcx,  0
       jz  label175
label174:
       mov  rax,  qword [rbp-224]
       add  rax,  1
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-200]
       mov  rdi,  rax
       mov  rax,  qword [rbp-272]
       mov  rsi,  rax
       mov  rax,  qword [rbp-24]
       mov  rdx,  rax
       call  update
       jmp  label176
label175:
       jmp  label176
label176:
       mov  rcx,  qword[sum]
       mov  rdx,  qword [rbp-184]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword[sum]
       mov  r9,  qword [rbp-200]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       add  rax,  r10
       mov  qword [rbp-280],  rax
       mov  rdx,  qword [rbp-280]
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rcx,  qword[flag]
       mov  rdx,  qword [rbp-184]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword[flag]
       mov  r9,  qword [rbp-200]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       and  rax,  r10
       mov  qword [rbp-288],  rax
       mov  rdx,  qword [rbp-288]
       mov  rax,  qword[flag]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rcx,  qword[flag]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jle  label184
label183:
       mov  qword [rbp-296],  1
       jmp  label185
label184:
       mov  qword [rbp-296],  0
label185:
       mov  rcx,  qword [rbp-296]
       cmp  rcx,  0
       jz  label181
label180:
       mov  qword [rbp-304],  0
       mov  qword [rbp-304],  0
label188:
       mov  rcx,  qword [rbp-304]
       mov  rdx,  qword[L]
       cmp  rcx,  rdx
       jge  label191
label190:
       mov  qword [rbp-312],  1
       jmp  label192
label191:
       mov  qword [rbp-312],  0
label192:
       mov  rcx,  qword [rbp-312]
       cmp  rcx,  0
       jz  label187
label186:
       mov  rax,  qword [rbp-304]
       mov  rdx,  qword[now]
       mov  rbx,  qword [rbp-184]
       add  rbx,  1
       mov  r8,  qword [rdx + rbx * 8]
       add  rax,  r8
       mov  qword [rbp-320],  rax
       mov  rax,  qword [rbp-320]
       mov  rdx,  rax
       mov  rcx,  qword[L]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-328],  rdx
       mov  rax,  qword [rbp-304]
       mov  rdx,  qword[now]
       mov  rbx,  qword [rbp-200]
       add  rbx,  1
       mov  r8,  qword [rdx + rbx * 8]
       add  rax,  r8
       mov  qword [rbp-336],  rax
       mov  rax,  qword [rbp-336]
       mov  rdx,  rax
       mov  rcx,  qword[L]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-344],  rdx
       mov  rbx,  qword[s]
       mov  r8,  qword [rbp-184]
       add  r8,  1
       mov  rcx,  qword [rbx + r8 * 8]
       mov  rdx,  qword [rbp-328]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r12,  qword[s]
       mov  r13,  qword [rbp-200]
       add  r13,  1
       mov  r10,  qword [r12 + r13 * 8]
       mov  r11,  qword [rbp-344]
       add  r11,  1
       mov  r14,  qword [r10 + r11 * 8]
       add  rax,  r14
       mov  qword [rbp-352],  rax
       mov  r8,  qword [rbp-352]
       mov  rdx,  qword[s]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-304]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
label189:
       mov  rax,  qword [rbp-304]
       add  rax,  1
       mov  qword [rbp-304],  rax
       jmp  label188
label187:
       mov  rax,  qword[now]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  0
       jmp  label182
label181:
       jmp  label182
label182:
       add  rsp,  368
       pop  rbp
       ret  
       add  rsp,  368
       pop  rbp
       ret  
query:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  224
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  rdx
       mov  rcx,  qword[pl]
       mov  rdx,  qword [rbp-16]
       cmp  rcx,  rdx
       jg  label202
label201:
       mov  qword [rbp-32],  1
       jmp  label203
label202:
       mov  qword [rbp-32],  0
label203:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label199
label196:
       mov  rcx,  qword[pr]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       jl  label205
label204:
       mov  qword [rbp-40],  1
       jmp  label206
label205:
       mov  qword [rbp-40],  0
label206:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label199
label198:
       mov  qword [rbp-48],  1
       jmp  label200
label199:
       mov  qword [rbp-48],  0
label200:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jz  label194
label193:
       mov  rax,  qword[sum]
       mov  rcx,  qword [rbp-8]
       add  rcx,  1
       mov  rdx,  qword [rax + rcx * 8]
       mov  rax,  rdx
       add  rsp,  224
       pop  rbp
       ret  
       jmp  label195
label194:
       jmp  label195
label195:
       mov  rax,  qword [rbp-8]
       imul  rax,  2
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-8]
       imul  rax,  2
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       add  rax,  1
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-16]
       mov  rdx,  qword [rbp-24]
       add  rax,  rdx
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  rcx,  2
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       mov  qword [rbp-96],  rax
       mov  qword [rbp-120],  0
       mov  rcx,  qword[t]
       mov  rdx,  qword [rbp-8]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       cmp  rbx,  0
       jle  label211
label210:
       mov  qword [rbp-128],  1
       jmp  label212
label211:
       mov  qword [rbp-128],  0
label212:
       mov  rcx,  qword [rbp-128]
       cmp  rcx,  0
       jz  label208
label207:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  pushdown
       jmp  label209
label208:
       jmp  label209
label209:
       mov  rcx,  qword[pl]
       mov  rdx,  qword [rbp-96]
       cmp  rcx,  rdx
       jg  label217
label216:
       mov  qword [rbp-136],  1
       jmp  label218
label217:
       mov  qword [rbp-136],  0
label218:
       mov  rcx,  qword [rbp-136]
       cmp  rcx,  0
       jz  label214
label213:
       mov  rax,  qword [rbp-56]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       mov  rax,  qword [rbp-96]
       mov  rdx,  rax
       call  query
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-120]
       mov  rdx,  qword [rbp-144]
       add  rax,  rdx
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       mov  rdx,  rax
       mov  rcx,  qword[MOD]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-160],  rdx
       mov  rax,  qword [rbp-160]
       mov  qword [rbp-120],  rax
       jmp  label215
label214:
       jmp  label215
label215:
       mov  rax,  qword [rbp-96]
       add  rax,  1
       mov  qword [rbp-168],  rax
       mov  rcx,  qword[pr]
       mov  rdx,  qword [rbp-168]
       cmp  rcx,  rdx
       jl  label223
label222:
       mov  qword [rbp-176],  1
       jmp  label224
label223:
       mov  qword [rbp-176],  0
label224:
       mov  rcx,  qword [rbp-176]
       cmp  rcx,  0
       jz  label220
label219:
       mov  rax,  qword [rbp-96]
       add  rax,  1
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-72]
       mov  rdi,  rax
       mov  rax,  qword [rbp-192]
       mov  rsi,  rax
       mov  rax,  qword [rbp-24]
       mov  rdx,  rax
       call  query
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-120]
       mov  rdx,  qword [rbp-184]
       add  rax,  rdx
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-200]
       mov  rdx,  rax
       mov  rcx,  qword[MOD]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-208],  rdx
       mov  rax,  qword [rbp-208]
       mov  qword [rbp-120],  rax
       jmp  label221
label220:
       jmp  label221
label221:
       mov  rax,  qword [rbp-120]
       add  rsp,  224
       pop  rbp
       ret  
       add  rsp,  224
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  176
       mov  rdi,  4000048
       call  malloc
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword [rax + 0],  500005
       mov  rax,  qword [rbp-8]
       mov  qword[b],  rax
       mov  rdi,  4000048
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  500005
       mov  rax,  qword [rbp-16]
       mov  qword[now],  rax
       mov  rdi,  4000048
       call  malloc
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rax + 0],  500005
       mov  rax,  qword [rbp-24]
       mov  qword[t],  rax
       mov  rdi,  1600048
       call  malloc
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword [rax + 0],  200005
       mov  rax,  qword [rbp-32]
       mov  qword[a],  rax
       mov  rdi,  4000048
       call  malloc
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       mov  qword [rax + 0],  500005
       mov  rax,  qword [rbp-40]
       mov  qword[flag],  rax
       mov  rdi,  4000048
       call  malloc
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  qword [rax + 0],  500005
       mov  qword [rbp-56],  0
label0:
       mov  rdi,  648
       call  malloc
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword [rbp-56]
       add  rdx,  1
       mov  qword [rcx + rdx * 8],  rax
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword [rbp-56]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 0],  80
       mov  qword [rbp-64],  0
       mov  rax,  qword [rbp-56]
       add  rax,  1
       mov  qword [rbp-56],  rax
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  500005
       jg  label1
       jmp  label0
label1:
       mov  rax,  qword [rbp-48]
       mov  qword[s],  rax
       mov  rdi,  4000048
       call  malloc
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  qword [rax + 0],  500005
       mov  rax,  qword [rbp-80]
       mov  qword[sum],  rax
       mov  rax,  2
       mov  rcx,  14
       sal  rax,  cl
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       sub  rax,  7
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       mov  qword[MOD],  rax
       call  getInt
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword[n],  rax
       call  getInt
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword[m],  rax
       call  getInt
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword[p],  rax
       mov  qword [rbp-32],  1
       mov  qword [rbp-32],  1
label227:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[n]
       cmp  rcx,  rdx
       jg  label230
label229:
       mov  qword [rbp-40],  1
       jmp  label231
label230:
       mov  qword [rbp-40],  0
label231:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label226
label225:
       mov  rdi,  0
       mov  rax,  qword[p]
       mov  rsi,  rax
       call  RandRange
       mov  qword [rbp-48],  rax
       mov  rdx,  qword [rbp-48]
       mov  rax,  qword[a]
       mov  rcx,  qword [rbp-32]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
label228:
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       jmp  label227
label226:
       call  init
       mov  rdi,  1
       mov  rsi,  1
       mov  rax,  qword[n]
       mov  rdx,  rax
       call  build
label234:
       mov  rcx,  qword[m]
       cmp  rcx,  0
       jle  label236
label235:
       mov  qword [rbp-56],  1
       jmp  label237
label236:
       mov  qword [rbp-56],  0
label237:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label233
label232:
       call  Rand
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  rdx,  rax
       mov  rcx,  2
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-72],  rdx
       mov  rax,  qword [rbp-72]
       mov  qword[op],  rax
       mov  rdi,  1
       mov  rax,  qword[n]
       mov  rsi,  rax
       call  RandRange
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  qword[pl],  rax
       mov  rdi,  1
       mov  rax,  qword[n]
       mov  rsi,  rax
       call  RandRange
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  qword[pr],  rax
label240:
       mov  rcx,  qword[pr]
       mov  rdx,  qword[pl]
       cmp  rcx,  rdx
       jg  label242
label241:
       mov  qword [rbp-96],  1
       jmp  label243
label242:
       mov  qword [rbp-96],  0
label243:
       mov  rcx,  qword [rbp-96]
       cmp  rcx,  0
       jz  label239
label238:
       mov  rdi,  1
       mov  rax,  qword[n]
       mov  rsi,  rax
       call  RandRange
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  qword[pr],  rax
       jmp  label240
label239:
       mov  rcx,  qword[op]
       cmp  rcx,  0
       jne  label248
label247:
       mov  qword [rbp-112],  1
       jmp  label249
label248:
       mov  qword [rbp-112],  0
label249:
       mov  rcx,  qword [rbp-112]
       cmp  rcx,  0
       jz  label245
label244:
       mov  rdi,  1
       mov  rsi,  1
       mov  rax,  qword[n]
       mov  rdx,  rax
       call  update
       jmp  label246
label245:
       jmp  label246
label246:
       mov  rcx,  qword[op]
       cmp  rcx,  1
       jne  label254
label253:
       mov  qword [rbp-120],  1
       jmp  label255
label254:
       mov  qword [rbp-120],  0
label255:
       mov  rcx,  qword [rbp-120]
       cmp  rcx,  0
       jz  label251
label250:
       mov  rdi,  1
       mov  rsi,  1
       mov  rax,  qword[n]
       mov  rdx,  rax
       call  query
       mov  qword [rbp-128],  rax
       mov  rax,  qword[ans]
       mov  rdx,  qword [rbp-128]
       add  rax,  rdx
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  rdx,  rax
       mov  rcx,  qword[MOD]
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-144],  rdx
       mov  rax,  qword [rbp-144]
       mov  qword[ans],  rax
       jmp  label252
label251:
       jmp  label252
label252:
       mov  rax,  qword[m]
       mov  qword [rbp-152],  rax
       mov  rax,  qword[m]
       sub  rax,  1
       mov  qword[m],  rax
       jmp  label234
label233:
       mov  rax,  qword[ans]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-160],  rax
       mov  rax,  qword [rbp-160]
       mov  rdi,  rax
       call  print
       mov  rax,  0
       add  rsp,  176
       pop  rbp
       ret  
       add  rsp,  176
       pop  rbp
       ret  

section .data
L:
       dq  1
ans:
       dq  0
aa:
       dq  13131
bb:
       dq  5353
no:
       dq  1
pl:
       dq  0
pr:
       dq  0

section .bss

b:       resq  1
now:       resq  1
t:       resq  1
a:       resq  1
n:       resq  1
m:       resq  1
p:       resq  1
op:       resq  1
flag:       resq  1
s:       resq  1
sum:       resq  1
MOD:       resq  1


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
