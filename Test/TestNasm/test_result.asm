global    Calculate_p
global    m
global    Ksm
global    b
global    Calculate_q
global    q
global    tot
global    Sum
global    ksm
global    init
global    fm
global    N
global    Mod
global    Calculate_G
global    main
global    g
global    Euler
global    Calculate_Ksm
global    fc
global    prime
global    fn
global    Comb
global    p
global    res
global    C
global    M
global    Calculate_Comb
global    v


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

init:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  944
       mov  qword[tot],  0
       mov  qword[C],  0
       mov  qword[M],  0
       mov  qword[N],  0
       mov  rdi,  56
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  6
       mov  qword [rbp-8],  0
       mov  qword[g],  rbx
       mov  qword [rbp-16],  0
       jmp  label4
label4:
       mov  r15,  qword [rbp-16]
       cmp  r15,  6
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
       mov  r14,  qword[g]
       mov  rbx,  r14
       mov  rdi,  800016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-24],  rax
       mov  r13,  qword [rbp-24]
       mov  qword [r13 + 0],  100001
       mov  qword [rbp-32],  0
       mov  r12,  qword [rbp-24]
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  r12
       mov  qword [rbp-40],  0
       jmp  label13
label13:
       mov  r15,  qword [rbp-40]
       cmp  r15,  100001
       jge  label16
label15:
       mov  rbx,  1
       jmp  label17
label16:
       mov  rbx,  0
       jmp  label17
label17:
       cmp  rbx,  0
       jz  label12
label11:
       mov  r14,  qword[g]
       mov  rbx,  r14
       mov  r13,  qword [rbp-16]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  qword [rbp-48],  r11
       mov  rdi,  128
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  15
       mov  r10,  qword [rbp-48]
       mov  r15,  qword [rbp-40]
       mov  r14,  r15
       add  r14,  1
       mov  qword [r10 + r14 * 8],  rbx
       mov  qword [rbp-56],  0
       jmp  label20
label20:
       mov  r13,  qword [rbp-56]
       cmp  r13,  15
       jge  label23
label22:
       mov  rbx,  1
       jmp  label24
label23:
       mov  rbx,  0
       jmp  label24
label24:
       cmp  rbx,  0
       jz  label19
label18:
       mov  r12,  qword[g]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  rbx,  r15
       mov  r14,  qword [rbp-40]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword [rbp-56]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label21
label21:
       mov  r15,  qword [rbp-56]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-56],  r14
       jmp  label20
label19:
       jmp  label14
label14:
       mov  r13,  qword [rbp-40]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-40],  r12
       jmp  label13
label12:
       jmp  label5
label5:
       mov  r11,  qword [rbp-16]
       mov  rbx,  r11
       mov  r10,  rbx
       add  r10,  1
       mov  qword [rbp-16],  r10
       jmp  label4
label3:
       mov  rdi,  56
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  6
       mov  qword [rbp-64],  0
       mov  qword[Sum],  rbx
       mov  qword [rbp-16],  0
       jmp  label29
label29:
       mov  r15,  qword [rbp-16]
       cmp  r15,  6
       jge  label32
label31:
       mov  rbx,  1
       jmp  label33
label32:
       mov  rbx,  0
       jmp  label33
label33:
       cmp  rbx,  0
       jz  label28
label27:
       mov  r14,  qword[Sum]
       mov  rbx,  r14
       mov  rdi,  800016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-72],  rax
       mov  r13,  qword [rbp-72]
       mov  qword [r13 + 0],  100001
       mov  qword [rbp-80],  0
       mov  r12,  qword [rbp-72]
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  r12
       mov  qword [rbp-40],  0
       jmp  label38
label38:
       mov  r15,  qword [rbp-40]
       cmp  r15,  100001
       jge  label41
label40:
       mov  rbx,  1
       jmp  label42
label41:
       mov  rbx,  0
       jmp  label42
label42:
       cmp  rbx,  0
       jz  label37
label36:
       mov  r14,  qword[Sum]
       mov  rbx,  r14
       mov  r13,  qword [rbp-16]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  qword [rbp-88],  r11
       mov  rdi,  128
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  15
       mov  r10,  qword [rbp-88]
       mov  r15,  qword [rbp-40]
       mov  r14,  r15
       add  r14,  1
       mov  qword [r10 + r14 * 8],  rbx
       mov  qword [rbp-56],  0
       jmp  label45
label45:
       mov  r13,  qword [rbp-56]
       cmp  r13,  15
       jge  label48
label47:
       mov  rbx,  1
       jmp  label49
label48:
       mov  rbx,  0
       jmp  label49
label49:
       cmp  rbx,  0
       jz  label44
label43:
       mov  r12,  qword[Sum]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  rbx,  r15
       mov  r14,  qword [rbp-40]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword [rbp-56]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label46
label46:
       mov  r15,  qword [rbp-56]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-56],  r14
       jmp  label45
label44:
       jmp  label39
label39:
       mov  r13,  qword [rbp-40]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-40],  r12
       jmp  label38
label37:
       jmp  label30
label30:
       mov  r11,  qword [rbp-16]
       mov  rbx,  r11
       mov  r10,  rbx
       add  r10,  1
       mov  qword [rbp-16],  r10
       jmp  label29
label28:
       mov  rdi,  8016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword [rbp-96],  0
       mov  qword[fm],  rbx
       mov  qword [rbp-16],  0
       jmp  label54
label54:
       mov  r15,  qword [rbp-16]
       cmp  r15,  1001
       jge  label57
label56:
       mov  rbx,  1
       jmp  label58
label57:
       mov  rbx,  0
       jmp  label58
label58:
       cmp  rbx,  0
       jz  label53
label52:
       mov  r14,  qword[fm]
       mov  qword [rbp-104],  r14
       mov  rdi,  112
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  13
       mov  r13,  qword [rbp-104]
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  qword [r13 + r11 * 8],  rbx
       mov  qword [rbp-40],  0
       jmp  label61
label61:
       mov  r10,  qword [rbp-40]
       cmp  r10,  13
       jge  label64
label63:
       mov  rbx,  1
       jmp  label65
label64:
       mov  rbx,  0
       jmp  label65
label65:
       cmp  rbx,  0
       jz  label60
label59:
       mov  r15,  qword[fm]
       mov  rbx,  r15
       mov  r14,  qword [rbp-16]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword [rbp-40]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label62
label62:
       mov  r15,  qword [rbp-40]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-40],  r14
       jmp  label61
label60:
       jmp  label55
label55:
       mov  r13,  qword [rbp-16]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-16],  r12
       jmp  label54
label53:
       mov  rdi,  800016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-112],  rax
       mov  r11,  qword [rbp-112]
       mov  qword [r11 + 0],  100001
       mov  rbx,  0
       mov  r10,  qword [rbp-112]
       mov  qword[ksm],  r10
       mov  qword [rbp-16],  0
       jmp  label70
label70:
       mov  r15,  qword [rbp-16]
       cmp  r15,  100001
       jge  label73
label72:
       mov  rbx,  1
       jmp  label74
label73:
       mov  rbx,  0
       jmp  label74
label74:
       cmp  rbx,  0
       jz  label69
label68:
       mov  r14,  qword[ksm]
       mov  rbx,  r14
       mov  rdi,  176
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-120],  rax
       mov  r13,  qword [rbp-120]
       mov  qword [r13 + 0],  21
       mov  r12,  qword [rbp-120]
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  r12
       mov  qword [rbp-40],  0
       jmp  label77
label77:
       mov  r15,  qword [rbp-40]
       cmp  r15,  21
       jge  label80
label79:
       mov  rbx,  1
       jmp  label81
label80:
       mov  rbx,  0
       jmp  label81
label81:
       cmp  rbx,  0
       jz  label76
label75:
       mov  r14,  qword[ksm]
       mov  rbx,  r14
       mov  r13,  qword [rbp-16]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  rbx,  r11
       mov  r10,  qword [rbp-40]
       mov  r15,  r10
       add  r15,  1
       mov  qword [rbx + r15 * 8],  0
       jmp  label78
label78:
       mov  r14,  qword [rbp-40]
       mov  rbx,  r14
       mov  r13,  rbx
       add  r13,  1
       mov  qword [rbp-40],  r13
       jmp  label77
label76:
       jmp  label71
label71:
       mov  r12,  qword [rbp-16]
       mov  rbx,  r12
       mov  r11,  rbx
       add  r11,  1
       mov  qword [rbp-16],  r11
       jmp  label70
label69:
       mov  rdi,  176
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-128],  rax
       mov  r10,  qword [rbp-128]
       mov  qword [r10 + 0],  21
       mov  rbx,  0
       mov  r15,  qword [rbp-128]
       mov  qword[p],  r15
       mov  qword [rbp-16],  0
       jmp  label86
label86:
       mov  r14,  qword [rbp-16]
       cmp  r14,  21
       jge  label89
label88:
       mov  rbx,  1
       jmp  label90
label89:
       mov  rbx,  0
       jmp  label90
label90:
       cmp  rbx,  0
       jz  label85
label84:
       mov  r13,  qword[p]
       mov  rbx,  r13
       mov  rdi,  176
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-136],  rax
       mov  r12,  qword [rbp-136]
       mov  qword [r12 + 0],  21
       mov  r11,  qword [rbp-136]
       mov  r10,  qword [rbp-16]
       mov  r15,  r10
       add  r15,  1
       mov  qword [rbx + r15 * 8],  r11
       mov  qword [rbp-40],  0
       jmp  label93
label93:
       mov  r14,  qword [rbp-40]
       cmp  r14,  21
       jge  label96
label95:
       mov  rbx,  1
       jmp  label97
label96:
       mov  rbx,  0
       jmp  label97
label97:
       cmp  rbx,  0
       jz  label92
label91:
       mov  r13,  qword[p]
       mov  rbx,  r13
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword [rbp-40]
       mov  r14,  r15
       add  r14,  1
       mov  qword [rbx + r14 * 8],  0
       jmp  label94
label94:
       mov  r13,  qword [rbp-40]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-40],  r12
       jmp  label93
label92:
       jmp  label87
label87:
       mov  r11,  qword [rbp-16]
       mov  rbx,  r11
       mov  r10,  rbx
       add  r10,  1
       mov  qword [rbp-16],  r10
       jmp  label86
label85:
       mov  rdi,  176
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-144],  rax
       mov  r15,  qword [rbp-144]
       mov  qword [r15 + 0],  21
       mov  rbx,  0
       mov  r14,  qword [rbp-144]
       mov  qword[q],  r14
       mov  qword [rbp-16],  0
       jmp  label102
label102:
       mov  r13,  qword [rbp-16]
       cmp  r13,  21
       jge  label105
label104:
       mov  rbx,  1
       jmp  label106
label105:
       mov  rbx,  0
       jmp  label106
label106:
       cmp  rbx,  0
       jz  label101
label100:
       mov  r12,  qword[q]
       mov  rbx,  r12
       mov  rdi,  800016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-152],  rax
       mov  r11,  qword [rbp-152]
       mov  qword [r11 + 0],  100001
       mov  r10,  qword [rbp-152]
       mov  r15,  qword [rbp-16]
       mov  r14,  r15
       add  r14,  1
       mov  qword [rbx + r14 * 8],  r10
       mov  qword [rbp-40],  0
       jmp  label109
label109:
       mov  r13,  qword [rbp-40]
       cmp  r13,  100001
       jge  label112
label111:
       mov  rbx,  1
       jmp  label113
label112:
       mov  rbx,  0
       jmp  label113
label113:
       cmp  rbx,  0
       jz  label108
label107:
       mov  r12,  qword[q]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  rbx,  r15
       mov  r14,  qword [rbp-40]
       mov  r13,  r14
       add  r13,  1
       mov  qword [rbx + r13 * 8],  0
       jmp  label110
label110:
       mov  r12,  qword [rbp-40]
       mov  rbx,  r12
       mov  r11,  rbx
       add  r11,  1
       mov  qword [rbp-40],  r11
       jmp  label109
label108:
       jmp  label103
label103:
       mov  r10,  qword [rbp-16]
       mov  rbx,  r10
       mov  r15,  rbx
       add  r15,  1
       mov  qword [rbp-16],  r15
       jmp  label102
label101:
       mov  rdi,  800016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-160],  rax
       mov  r14,  qword [rbp-160]
       mov  qword [r14 + 0],  100001
       mov  rbx,  0
       mov  r13,  qword [rbp-160]
       mov  qword[Comb],  r13
       mov  qword [rbp-16],  0
       jmp  label118
label118:
       mov  r12,  qword [rbp-16]
       cmp  r12,  100001
       jge  label121
label120:
       mov  rbx,  1
       jmp  label122
label121:
       mov  rbx,  0
       jmp  label122
label122:
       cmp  rbx,  0
       jz  label117
label116:
       mov  r11,  qword[Comb]
       mov  rbx,  r11
       mov  rdi,  176
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  qword [rbp-168],  rax
       mov  r10,  qword [rbp-168]
       mov  qword [r10 + 0],  21
       mov  r15,  qword [rbp-168]
       mov  r14,  qword [rbp-16]
       mov  r13,  r14
       add  r13,  1
       mov  qword [rbx + r13 * 8],  r15
       mov  qword [rbp-40],  0
       jmp  label125
label125:
       mov  r12,  qword [rbp-40]
       cmp  r12,  21
       jge  label128
label127:
       mov  rbx,  1
       jmp  label129
label128:
       mov  rbx,  0
       jmp  label129
label129:
       cmp  rbx,  0
       jz  label124
label123:
       mov  r11,  qword[Comb]
       mov  rbx,  r11
       mov  r10,  qword [rbp-16]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  rbx,  r14
       mov  r13,  qword [rbp-40]
       mov  r12,  r13
       add  r12,  1
       mov  qword [rbx + r12 * 8],  0
       jmp  label126
label126:
       mov  r11,  qword [rbp-40]
       mov  rbx,  r11
       mov  r10,  rbx
       add  r10,  1
       mov  qword [rbp-40],  r10
       jmp  label125
label124:
       jmp  label119
label119:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-16],  r14
       jmp  label118
label117:
       mov  rdi,  8016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[fn],  rbx
       mov  qword [rbp-16],  0
       jmp  label132
label132:
       mov  r13,  qword [rbp-16]
       cmp  r13,  1001
       jge  label135
label134:
       mov  rbx,  1
       jmp  label136
label135:
       mov  rbx,  0
       jmp  label136
label136:
       cmp  rbx,  0
       jz  label131
label130:
       mov  r12,  qword[fn]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label133
label133:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-16],  r14
       jmp  label132
label131:
       mov  rdi,  8016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[fc],  rbx
       mov  qword [rbp-16],  0
       jmp  label139
label139:
       mov  r13,  qword [rbp-16]
       cmp  r13,  1001
       jge  label142
label141:
       mov  rbx,  1
       jmp  label143
label142:
       mov  rbx,  0
       jmp  label143
label143:
       cmp  rbx,  0
       jz  label138
label137:
       mov  r12,  qword[fc]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label140
label140:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-16],  r14
       jmp  label139
label138:
       mov  rdi,  8016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[m],  rbx
       mov  qword [rbp-16],  0
       jmp  label146
label146:
       mov  r13,  qword [rbp-16]
       cmp  r13,  1001
       jge  label149
label148:
       mov  rbx,  1
       jmp  label150
label149:
       mov  rbx,  0
       jmp  label150
label150:
       cmp  rbx,  0
       jz  label145
label144:
       mov  r12,  qword[m]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label147
label147:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-16],  r14
       jmp  label146
label145:
       mov  rdi,  8016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[res],  rbx
       mov  qword [rbp-16],  0
       jmp  label153
label153:
       mov  r13,  qword [rbp-16]
       cmp  r13,  1001
       jge  label156
label155:
       mov  rbx,  1
       jmp  label157
label156:
       mov  rbx,  0
       jmp  label157
label157:
       cmp  rbx,  0
       jz  label152
label151:
       mov  r12,  qword[res]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label154
label154:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-16],  r14
       jmp  label153
label152:
       mov  rdi,  8016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[b],  rbx
       mov  qword [rbp-16],  0
       jmp  label160
label160:
       mov  r13,  qword [rbp-16]
       cmp  r13,  1001
       jge  label163
label162:
       mov  rbx,  1
       jmp  label164
label163:
       mov  rbx,  0
       jmp  label164
label164:
       cmp  rbx,  0
       jz  label159
label158:
       mov  r12,  qword[b]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label161
label161:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-16],  r14
       jmp  label160
label159:
       mov  rdi,  800016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  100001
       mov  qword[v],  rbx
       mov  qword [rbp-16],  0
       jmp  label167
label167:
       mov  r13,  qword [rbp-16]
       cmp  r13,  100001
       jge  label170
label169:
       mov  rbx,  1
       jmp  label171
label170:
       mov  rbx,  0
       jmp  label171
label171:
       cmp  rbx,  0
       jz  label166
label165:
       mov  r12,  qword[v]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label168
label168:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-16],  r14
       jmp  label167
label166:
       mov  rdi,  800016
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbx + 0],  100001
       mov  qword[prime],  rbx
       mov  qword [rbp-16],  0
       jmp  label174
label174:
       mov  r13,  qword [rbp-16]
       cmp  r13,  100001
       jge  label177
label176:
       mov  rbx,  1
       jmp  label178
label177:
       mov  rbx,  0
       jmp  label178
label178:
       cmp  rbx,  0
       jz  label173
label172:
       mov  r12,  qword[prime]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  qword [rbx + r10 * 8],  0
       jmp  label175
label175:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-16],  r14
       jmp  label174
label173:
       add  rsp,  944
       pop  rbp
       ret  
       add  rsp,  944
       pop  rbp
       ret  
Ksm:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  144
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  r13,  qword [rbp-16]
       cmp  r13,  0
       jne  label183
label182:
       mov  rbx,  1
       jmp  label184
label183:
       mov  rbx,  0
       jmp  label184
label184:
       cmp  rbx,  0
       jz  label180
label179:
       mov  rax,  1
       add  rsp,  144
       pop  rbp
       ret  
       jmp  label181
label180:
       jmp  label181
label181:
       mov  r12,  qword [rbp-16]
       cmp  r12,  1
       jne  label189
label188:
       mov  rbx,  1
       jmp  label190
label189:
       mov  rbx,  0
       jmp  label190
label190:
       cmp  rbx,  0
       jz  label186
label185:
       mov  r11,  qword [rbp-8]
       mov  rbx,  r11
       mov  r10,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r10
       mov  rbx,  rdx
       mov  rax,  rbx
       add  rsp,  144
       pop  rbp
       ret  
       jmp  label187
label186:
       jmp  label187
label187:
       mov  r15,  qword [rbp-16]
       mov  rbx,  r15
       mov  rcx,  1
       sar  rbx,  cl
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-8]
       mov  rsi,  rbx
       call  Ksm
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbp-24],  rbx
       mov  r14,  qword [rbp-16]
       mov  rbx,  r14
       mov  rax,  rbx
       mov  r13,  2
       mov  rdx,  0
       idiv  r13
       mov  rbx,  rdx
       cmp  rbx,  1
       jne  label195
label194:
       mov  rbx,  1
       jmp  label196
label195:
       mov  rbx,  0
       jmp  label196
label196:
       cmp  rbx,  0
       jz  label192
label191:
       mov  r12,  qword [rbp-24]
       mov  rbx,  r12
       mov  r11,  qword [rbp-24]
       imul  rbx,  r11
       mov  rbx,  rbx
       mov  r10,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r10
       mov  rbx,  rdx
       mov  r15,  qword [rbp-8]
       imul  rbx,  r15
       mov  rbx,  rbx
       mov  r14,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r14
       mov  rbx,  rdx
       mov  rax,  rbx
       add  rsp,  144
       pop  rbp
       ret  
       jmp  label193
label192:
       mov  r13,  qword [rbp-24]
       mov  rbx,  r13
       mov  r12,  qword [rbp-24]
       imul  rbx,  r12
       mov  rbx,  rbx
       mov  r11,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r11
       mov  rbx,  rdx
       mov  rax,  rbx
       add  rsp,  144
       pop  rbp
       ret  
       jmp  label193
label193:
       add  rsp,  144
       pop  rbp
       ret  
Calculate_p:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  320
       mov  r10,  qword[p]
       mov  rbx,  r10
       mov  r15,  qword [rbx + 8]
       mov  rbx,  r15
       mov  qword [rbx + 8],  1
       mov  r14,  qword[p]
       mov  rbx,  r14
       mov  r13,  qword [rbx + 16]
       mov  rbx,  r13
       mov  qword [rbx + 16],  1
       mov  r12,  qword[p]
       mov  rbx,  r12
       mov  r11,  qword [rbx + 16]
       mov  qword [rbp-8],  r11
       mov  r10,  qword[Mod]
       mov  rbx,  r10
       sub  rbx,  1
       mov  r15,  qword [rbp-8]
       mov  qword [r15 + 8],  rbx
       mov  qword [rbp-16],  2
       jmp  label199
label199:
       mov  r14,  qword[C]
       mov  rbx,  r14
       sub  rbx,  2
       mov  r13,  qword [rbp-16]
       cmp  r13,  rbx
       jg  label202
label201:
       mov  rbx,  1
       jmp  label203
label202:
       mov  rbx,  0
       jmp  label203
label203:
       cmp  rbx,  0
       jz  label198
label197:
       mov  r12,  qword[Mod]
       mov  rbx,  r12
       sub  rbx,  2
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-16]
       mov  rsi,  rbx
       call  Ksm
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbp-24],  rbx
       mov  qword [rbp-32],  0
       jmp  label206
label206:
       mov  r11,  qword [rbp-32]
       mov  r10,  qword [rbp-16]
       cmp  r11,  r10
       jge  label209
label208:
       mov  rbx,  1
       jmp  label210
label209:
       mov  rbx,  0
       jmp  label210
label210:
       cmp  rbx,  0
       jz  label205
label204:
       mov  r15,  qword [rbp-32]
       mov  qword [rbp-40],  r15
       mov  r14,  qword [rbp-40]
       mov  r13,  r14
       add  r13,  1
       mov  qword [rbp-40],  r13
       mov  r12,  qword[p]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  qword [rbp-48],  r15
       mov  r14,  qword [rbp-16]
       mov  rbx,  r14
       sub  rbx,  1
       mov  r13,  qword[p]
       mov  qword [rbp-56],  r13
       mov  r12,  qword [rbp-56]
       mov  r11,  rbx
       add  r11,  1
       mov  r10,  qword [r12 + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword [rbp-32]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  r12,  qword [rbp-48]
       mov  r11,  qword [rbp-40]
       mov  r10,  r11
       add  r10,  1
       mov  qword [r12 + r10 * 8],  r13
       jmp  label207
label207:
       mov  r15,  qword [rbp-32]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-32],  r14
       jmp  label206
label205:
       mov  qword [rbp-32],  0
       jmp  label213
label213:
       mov  r13,  qword [rbp-32]
       mov  r12,  qword [rbp-16]
       cmp  r13,  r12
       jg  label216
label215:
       mov  rbx,  1
       jmp  label217
label216:
       mov  rbx,  0
       jmp  label217
label217:
       cmp  rbx,  0
       jz  label212
label211:
       mov  r11,  qword[p]
       mov  rbx,  r11
       mov  r10,  qword [rbp-16]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  qword [rbp-64],  r14
       mov  r13,  qword[p]
       mov  rbx,  r13
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword [rbp-16]
       mov  qword [rbp-72],  r15
       mov  r14,  qword [rbp-72]
       mov  r13,  r14
       sub  r13,  1
       mov  qword [rbp-72],  r13
       mov  r12,  qword[p]
       mov  qword [rbp-80],  r12
       mov  r11,  qword [rbp-80]
       mov  r10,  qword [rbp-72]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [r11 + r15 * 8]
       mov  qword [rbp-88],  r14
       mov  r13,  qword [rbp-88]
       mov  r12,  qword [rbp-32]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [r13 + r11 * 8]
       mov  qword [rbp-96],  r10
       mov  r15,  qword [rbp-96]
       mov  r14,  qword [rbp-16]
       mov  r13,  r15
       imul  r13,  r14
       mov  qword [rbp-96],  r13
       mov  r12,  qword [rbp-96]
       mov  qword [rbp-104],  r12
       mov  r11,  qword [rbp-104]
       mov  r10,  qword[Mod]
       mov  rax,  r11
       mov  rdx,  0
       idiv  r10
       mov  qword [rbp-104],  rdx
       mov  r14,  qword [rbp-32]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword [rbp-104]
       sub  rbx,  r11
       mov  rbx,  rbx
       mov  r10,  qword[Mod]
       add  rbx,  r10
       mov  rbx,  rbx
       mov  r15,  qword [rbp-24]
       imul  rbx,  r15
       mov  rbx,  rbx
       mov  r14,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r14
       mov  rbx,  rdx
       mov  r13,  qword [rbp-64]
       mov  r12,  qword [rbp-32]
       mov  r11,  r12
       add  r11,  1
       mov  qword [r13 + r11 * 8],  rbx
       jmp  label214
label214:
       mov  r10,  qword [rbp-32]
       mov  rbx,  r10
       mov  r15,  rbx
       add  r15,  1
       mov  qword [rbp-32],  r15
       jmp  label213
label212:
       jmp  label200
label200:
       mov  r14,  qword [rbp-16]
       mov  rbx,  r14
       mov  r13,  rbx
       add  r13,  1
       mov  qword [rbp-16],  r13
       jmp  label199
label198:
       add  rsp,  320
       pop  rbp
       ret  
       add  rsp,  320
       pop  rbp
       ret  
Euler:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  448
       mov  qword [rbp-8],  rdi
       mov  qword[tot],  0
       mov  r12,  qword[q]
       mov  rbx,  r12
       mov  r11,  qword [rbp-8]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  rbx,  r15
       mov  qword [rbx + 16],  1
       mov  qword [rbp-16],  0
       jmp  label220
label220:
       mov  r14,  qword [rbp-16]
       cmp  r14,  100001
       jge  label223
label222:
       mov  rbx,  1
       jmp  label224
label223:
       mov  rbx,  0
       jmp  label224
label224:
       cmp  rbx,  0
       jz  label219
label218:
       mov  r13,  qword[v]
       mov  rbx,  r13
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  qword [rbx + r11 * 8],  0
       jmp  label221
label221:
       mov  r10,  qword [rbp-16]
       mov  rbx,  r10
       mov  r15,  rbx
       add  r15,  1
       mov  qword [rbp-16],  r15
       jmp  label220
label219:
       mov  qword [rbp-16],  2
       jmp  label227
label227:
       mov  r14,  qword [rbp-16]
       mov  r13,  qword[M]
       cmp  r14,  r13
       jg  label230
label229:
       mov  rbx,  1
       jmp  label231
label230:
       mov  rbx,  0
       jmp  label231
label231:
       cmp  rbx,  0
       jz  label226
label225:
       mov  r12,  qword[v]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       cmp  r15,  0
       jne  label236
label235:
       mov  rbx,  1
       jmp  label237
label236:
       mov  rbx,  0
       jmp  label237
label237:
       cmp  rbx,  0
       jz  label233
label232:
       mov  r14,  qword[tot]
       mov  r13,  r14
       add  r13,  1
       mov  qword[tot],  r13
       mov  r12,  qword[prime]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  qword[tot]
       mov  r15,  r10
       add  r15,  1
       mov  qword [rbx + r15 * 8],  r11
       mov  r14,  qword[q]
       mov  rbx,  r14
       mov  r13,  qword [rbp-8]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  qword [rbp-24],  r11
       mov  r10,  qword[ksm]
       mov  rbx,  r10
       mov  r15,  qword [rbp-16]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword [rbp-8]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword[Mod]
       add  rbx,  r15
       mov  rbx,  rbx
       sub  rbx,  1
       mov  rbx,  rbx
       mov  r14,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r14
       mov  rbx,  rdx
       mov  r13,  qword [rbp-24]
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  qword [r13 + r11 * 8],  rbx
       jmp  label234
label233:
       jmp  label234
label234:
       mov  qword [rbp-32],  1
       jmp  label240
label240:
       mov  r10,  qword [rbp-32]
       mov  r15,  qword[tot]
       cmp  r10,  r15
       jg  label248
label247:
       mov  rbx,  1
       jmp  label249
label248:
       mov  rbx,  0
       jmp  label249
label249:
       cmp  rbx,  0
       jz  label245
label242:
       mov  r14,  qword[prime]
       mov  rbx,  r14
       mov  r13,  qword [rbp-32]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  rbx,  r11
       mov  r10,  qword [rbp-16]
       imul  rbx,  r10
       mov  r15,  qword[M]
       cmp  rbx,  r15
       jg  label251
label250:
       mov  rbx,  1
       jmp  label252
label251:
       mov  rbx,  0
       jmp  label252
label252:
       cmp  rbx,  0
       jz  label245
label244:
       mov  rbx,  1
       jmp  label246
label245:
       mov  rbx,  0
       jmp  label246
label246:
       cmp  rbx,  0
       jz  label239
label238:
       mov  r14,  qword[prime]
       mov  rbx,  r14
       mov  r13,  qword [rbp-32]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  rbx,  r11
       mov  r10,  qword [rbp-16]
       imul  rbx,  r10
       mov  r15,  qword[v]
       mov  qword [rbp-40],  r15
       mov  r14,  qword [rbp-40]
       mov  r13,  rbx
       add  r13,  1
       mov  qword [r14 + r13 * 8],  1
       mov  r12,  qword[prime]
       mov  qword [rbp-48],  r12
       mov  r11,  qword [rbp-16]
       mov  rbx,  r11
       mov  r10,  qword [rbp-48]
       mov  r15,  qword [rbp-32]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [r10 + r14 * 8]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r13
       mov  rbx,  rdx
       cmp  rbx,  0
       jne  label257
label256:
       mov  rbx,  1
       jmp  label258
label257:
       mov  rbx,  0
       jmp  label258
label258:
       cmp  rbx,  0
       jz  label254
label253:
       mov  r12,  qword[prime]
       mov  qword [rbp-56],  r12
       mov  r11,  qword [rbp-16]
       mov  rbx,  r11
       mov  r10,  qword [rbp-56]
       mov  r15,  qword [rbp-32]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [r10 + r14 * 8]
       imul  rbx,  r13
       mov  r12,  qword[q]
       mov  qword [rbp-64],  r12
       mov  r11,  qword [rbp-64]
       mov  r10,  qword [rbp-8]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [r11 + r15 * 8]
       mov  qword [rbp-72],  r14
       mov  r13,  qword[q]
       mov  qword [rbp-80],  r13
       mov  r12,  qword [rbp-80]
       mov  r11,  qword [rbp-8]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [r12 + r10 * 8]
       mov  qword [rbp-88],  r15
       mov  r14,  qword[prime]
       mov  qword [rbp-96],  r14
       mov  r13,  qword[ksm]
       mov  qword [rbp-104],  r13
       mov  r12,  qword [rbp-104]
       mov  r11,  qword [rbp-96]
       mov  r10,  qword [rbp-32]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [r11 + r15 * 8]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [r12 + r13 * 8]
       mov  qword [rbp-112],  r12
       mov  r11,  qword [rbp-88]
       mov  r10,  qword [rbp-16]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [r11 + r15 * 8]
       mov  qword [rbp-120],  r14
       mov  r13,  qword [rbp-120]
       mov  r12,  qword [rbp-112]
       mov  r11,  qword [rbp-8]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [r12 + r10 * 8]
       mov  r14,  r13
       imul  r14,  r15
       mov  qword [rbp-120],  r14
       mov  r13,  qword [rbp-120]
       mov  qword [rbp-128],  r13
       mov  r12,  qword [rbp-128]
       mov  r11,  qword[Mod]
       mov  rax,  r12
       mov  rdx,  0
       idiv  r11
       mov  qword [rbp-128],  rdx
       mov  r15,  qword [rbp-128]
       mov  r14,  qword [rbp-72]
       mov  r13,  rbx
       add  r13,  1
       mov  qword [r14 + r13 * 8],  r15
       jmp  label239
       jmp  label255
label254:
       mov  r12,  qword[prime]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  qword [rbp-136],  r11
       mov  r10,  qword [rbp-136]
       mov  r15,  qword [rbp-32]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  r12,  r10
       imul  r12,  r13
       mov  qword [rbp-136],  r12
       mov  r11,  qword[q]
       mov  rbx,  r11
       mov  r10,  qword [rbp-8]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  rbx,  r14
       mov  r13,  qword[q]
       mov  qword [rbp-144],  r13
       mov  r12,  qword [rbp-144]
       mov  r11,  qword [rbp-8]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [r12 + r10 * 8]
       mov  qword [rbp-152],  r15
       mov  r14,  qword[prime]
       mov  qword [rbp-160],  r14
       mov  r13,  qword[q]
       mov  qword [rbp-168],  r13
       mov  r12,  qword [rbp-168]
       mov  r11,  qword [rbp-8]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [r12 + r10 * 8]
       mov  qword [rbp-176],  r15
       mov  r14,  qword [rbp-152]
       mov  r13,  qword [rbp-16]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [r14 + r12 * 8]
       mov  qword [rbp-184],  r11
       mov  r10,  qword [rbp-184]
       mov  r15,  qword [rbp-176]
       mov  r14,  qword [rbp-160]
       mov  r13,  qword [rbp-32]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [r14 + r12 * 8]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [r15 + r10 * 8]
       mov  r14,  r10
       imul  r14,  r15
       mov  qword [rbp-184],  r14
       mov  r13,  qword [rbp-184]
       mov  qword [rbp-192],  r13
       mov  r12,  qword [rbp-192]
       mov  r11,  qword[Mod]
       mov  rax,  r12
       mov  rdx,  0
       idiv  r11
       mov  qword [rbp-192],  rdx
       mov  r15,  qword [rbp-192]
       mov  r14,  qword [rbp-136]
       mov  r13,  r14
       add  r13,  1
       mov  qword [rbx + r13 * 8],  r15
       jmp  label255
label255:
       jmp  label241
label241:
       mov  r12,  qword [rbp-32]
       mov  rbx,  r12
       mov  r11,  rbx
       add  r11,  1
       mov  qword [rbp-32],  r11
       jmp  label240
label239:
       jmp  label228
label228:
       mov  r10,  qword [rbp-16]
       mov  rbx,  r10
       mov  r15,  rbx
       add  r15,  1
       mov  qword [rbp-16],  r15
       jmp  label227
label226:
       add  rsp,  448
       pop  rbp
       ret  
       add  rsp,  448
       pop  rbp
       ret  
Calculate_q:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  48
       mov  qword [rbp-8],  0
       jmp  label261
label261:
       mov  r14,  qword[C]
       mov  rbx,  r14
       sub  rbx,  2
       mov  r13,  qword [rbp-8]
       cmp  r13,  rbx
       jg  label264
label263:
       mov  rbx,  1
       jmp  label265
label264:
       mov  rbx,  0
       jmp  label265
label265:
       cmp  rbx,  0
       jz  label260
label259:
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-8]
       call  Euler
       pop  rbp
       pop  rbx
       jmp  label262
label262:
       mov  r12,  qword [rbp-8]
       mov  rbx,  r12
       mov  r11,  rbx
       add  r11,  1
       mov  qword [rbp-8],  r11
       jmp  label261
label260:
       add  rsp,  48
       pop  rbp
       ret  
       add  rsp,  48
       pop  rbp
       ret  
Calculate_Ksm:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  144
       mov  qword [rbp-8],  1
       jmp  label268
label268:
       mov  r10,  qword [rbp-8]
       mov  r15,  qword[M]
       cmp  r10,  r15
       jg  label271
label270:
       mov  rbx,  1
       jmp  label272
label271:
       mov  rbx,  0
       jmp  label272
label272:
       cmp  rbx,  0
       jz  label267
label266:
       mov  r14,  qword[ksm]
       mov  rbx,  r14
       mov  r13,  qword [rbp-8]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  rbx,  r11
       mov  qword [rbx + 8],  1
       mov  qword [rbp-16],  1
       jmp  label275
label275:
       mov  r10,  qword[C]
       mov  rbx,  r10
       sub  rbx,  2
       mov  r15,  qword [rbp-16]
       cmp  r15,  rbx
       jg  label278
label277:
       mov  rbx,  1
       jmp  label279
label278:
       mov  rbx,  0
       jmp  label279
label279:
       cmp  rbx,  0
       jz  label274
label273:
       mov  r14,  qword[ksm]
       mov  rbx,  r14
       mov  r13,  qword [rbp-8]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  qword [rbp-24],  r11
       mov  r10,  qword [rbp-16]
       mov  qword [rbp-32],  r10
       mov  r15,  qword [rbp-32]
       mov  r14,  r15
       sub  r14,  1
       mov  qword [rbp-32],  r14
       mov  r13,  qword[ksm]
       mov  rbx,  r13
       mov  r12,  qword [rbp-8]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword [rbp-32]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword [rbp-8]
       imul  rbx,  r12
       mov  rbx,  rbx
       mov  r11,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r11
       mov  rbx,  rdx
       mov  r10,  qword [rbp-24]
       mov  r15,  qword [rbp-16]
       mov  r14,  r15
       add  r14,  1
       mov  qword [r10 + r14 * 8],  rbx
       jmp  label276
label276:
       mov  r13,  qword [rbp-16]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-16],  r12
       jmp  label275
label274:
       jmp  label269
label269:
       mov  r11,  qword [rbp-8]
       mov  rbx,  r11
       mov  r10,  rbx
       add  r10,  1
       mov  qword [rbp-8],  r10
       jmp  label268
label267:
       add  rsp,  144
       pop  rbp
       ret  
       add  rsp,  144
       pop  rbp
       ret  
Calculate_G:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  528
       push  rbx
       push  rbp
       call  Calculate_Ksm
       pop  rbp
       pop  rbx
       push  rbx
       push  rbp
       call  Calculate_p
       pop  rbp
       pop  rbx
       push  rbx
       push  rbp
       call  Calculate_q
       pop  rbp
       pop  rbx
       mov  qword [rbp-8],  1
       jmp  label282
label282:
       mov  r15,  qword [rbp-8]
       mov  r14,  qword[M]
       cmp  r15,  r14
       jg  label285
label284:
       mov  rbx,  1
       jmp  label286
label285:
       mov  rbx,  0
       jmp  label286
label286:
       cmp  rbx,  0
       jz  label281
label280:
       mov  qword [rbp-16],  2
       jmp  label289
label289:
       mov  r13,  qword [rbp-16]
       mov  r12,  qword[C]
       cmp  r13,  r12
       jg  label292
label291:
       mov  rbx,  1
       jmp  label293
label292:
       mov  rbx,  0
       jmp  label293
label293:
       cmp  rbx,  0
       jz  label288
label287:
       mov  qword [rbp-24],  0
       jmp  label296
label296:
       mov  r11,  qword [rbp-16]
       mov  rbx,  r11
       sub  rbx,  2
       mov  r10,  qword [rbp-24]
       cmp  r10,  rbx
       jg  label299
label298:
       mov  rbx,  1
       jmp  label300
label299:
       mov  rbx,  0
       jmp  label300
label300:
       cmp  rbx,  0
       jz  label295
label294:
       mov  r15,  qword[g]
       mov  rbx,  r15
       mov  r14,  qword [rbx + 8]
       mov  rbx,  r14
       mov  r13,  qword [rbp-8]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  qword [rbp-32],  r11
       mov  r10,  qword[g]
       mov  rbx,  r10
       mov  r15,  qword [rbx + 8]
       mov  rbx,  r15
       mov  r14,  qword [rbp-8]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  qword [rbp-40],  r12
       mov  r11,  qword [rbp-16]
       mov  qword [rbp-48],  r11
       mov  r10,  qword [rbp-48]
       mov  r15,  r10
       sub  r15,  2
       mov  qword [rbp-48],  r15
       mov  r14,  qword[p]
       mov  rbx,  r14
       mov  r13,  qword [rbp-48]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  qword [rbp-56],  r11
       mov  r10,  qword[q]
       mov  rbx,  r10
       mov  r15,  qword [rbp-24]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword [rbp-56]
       mov  r11,  qword [rbp-24]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [r12 + r10 * 8]
       mov  qword [rbp-64],  r15
       mov  r14,  qword [rbp-64]
       mov  r13,  qword [rbp-8]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  r10,  r14
       imul  r10,  r11
       mov  qword [rbp-64],  r10
       mov  r15,  qword [rbp-40]
       mov  r14,  qword [rbp-16]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [r15 + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword [rbp-64]
       add  rbx,  r11
       mov  rbx,  rbx
       mov  r10,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r10
       mov  rbx,  rdx
       mov  r15,  qword [rbp-32]
       mov  r14,  qword [rbp-16]
       mov  r13,  r14
       add  r13,  1
       mov  qword [r15 + r13 * 8],  rbx
       jmp  label297
label297:
       mov  r12,  qword [rbp-24]
       mov  rbx,  r12
       mov  r11,  rbx
       add  r11,  1
       mov  qword [rbp-24],  r11
       jmp  label296
label295:
       mov  qword [rbp-24],  1
       jmp  label303
label303:
       mov  r10,  qword [rbp-24]
       mov  r15,  qword[N]
       cmp  r10,  r15
       jg  label306
label305:
       mov  rbx,  1
       jmp  label307
label306:
       mov  rbx,  0
       jmp  label307
label307:
       cmp  rbx,  0
       jz  label302
label301:
       mov  r14,  qword[g]
       mov  rbx,  r14
       mov  r13,  qword [rbp-24]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  rbx,  r11
       mov  r10,  qword [rbp-8]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  qword [rbp-72],  r14
       mov  r13,  qword [rbp-24]
       mov  qword [rbp-80],  r13
       mov  r12,  qword [rbp-80]
       mov  r11,  r12
       sub  r11,  1
       mov  qword [rbp-80],  r11
       mov  r10,  qword[g]
       mov  rbx,  r10
       mov  r15,  qword [rbp-80]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword [rbp-8]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword [rbp-16]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword [rbp-8]
       imul  rbx,  r12
       mov  rbx,  rbx
       mov  r11,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r11
       mov  rbx,  rdx
       mov  r10,  qword [rbp-72]
       mov  r15,  qword [rbp-16]
       mov  r14,  r15
       add  r14,  1
       mov  qword [r10 + r14 * 8],  rbx
       jmp  label304
label304:
       mov  r13,  qword [rbp-24]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-24],  r12
       jmp  label303
label302:
       jmp  label290
label290:
       mov  r11,  qword [rbp-16]
       mov  rbx,  r11
       mov  r10,  rbx
       add  r10,  1
       mov  qword [rbp-16],  r10
       jmp  label289
label288:
       jmp  label283
label283:
       mov  r15,  qword [rbp-8]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-8],  r14
       jmp  label282
label281:
       mov  qword [rbp-24],  0
       jmp  label310
label310:
       mov  r13,  qword [rbp-24]
       mov  r12,  qword[N]
       cmp  r13,  r12
       jg  label313
label312:
       mov  rbx,  1
       jmp  label314
label313:
       mov  rbx,  0
       jmp  label314
label314:
       cmp  rbx,  0
       jz  label309
label308:
       mov  qword [rbp-8],  2
       jmp  label317
label317:
       mov  r11,  qword [rbp-8]
       mov  r10,  qword[C]
       cmp  r11,  r10
       jg  label320
label319:
       mov  rbx,  1
       jmp  label321
label320:
       mov  rbx,  0
       jmp  label321
label321:
       cmp  rbx,  0
       jz  label316
label315:
       mov  qword [rbp-16],  1
       jmp  label324
label324:
       mov  r15,  qword [rbp-16]
       mov  r14,  qword[M]
       cmp  r15,  r14
       jg  label327
label326:
       mov  rbx,  1
       jmp  label328
label327:
       mov  rbx,  0
       jmp  label328
label328:
       cmp  rbx,  0
       jz  label323
label322:
       mov  r13,  qword[Sum]
       mov  rbx,  r13
       mov  r12,  qword [rbp-24]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword [rbp-16]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  qword [rbp-88],  r13
       mov  r12,  qword [rbp-16]
       mov  rbx,  r12
       sub  rbx,  1
       mov  r11,  qword[Sum]
       mov  qword [rbp-96],  r11
       mov  r10,  qword [rbp-96]
       mov  r15,  qword [rbp-24]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [r10 + r14 * 8]
       mov  qword [rbp-104],  r13
       mov  r12,  qword [rbp-104]
       mov  r11,  rbx
       add  r11,  1
       mov  r10,  qword [r12 + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword[g]
       mov  qword [rbp-112],  r15
       mov  r14,  qword [rbp-112]
       mov  r13,  qword [rbp-24]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [r14 + r12 * 8]
       mov  qword [rbp-120],  r11
       mov  r10,  qword [rbp-120]
       mov  r15,  qword [rbp-16]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [r10 + r14 * 8]
       mov  qword [rbp-128],  r13
       mov  r12,  qword [rbp-8]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword [rbp-128]
       mov  r14,  qword [rbp-8]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [r15 + r13 * 8]
       add  rbx,  r12
       mov  r11,  qword [rbp-88]
       mov  r10,  qword [rbp-8]
       mov  r15,  r10
       add  r15,  1
       mov  qword [r11 + r15 * 8],  rbx
       mov  r14,  qword[Sum]
       mov  rbx,  r14
       mov  r13,  qword [rbp-24]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  rbx,  r11
       mov  r10,  qword [rbp-16]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  rbx,  r14
       mov  r13,  qword [rbp-8]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  r10,  qword[Mod]
       cmp  r11,  r10
       jl  label333
label332:
       mov  rbx,  1
       jmp  label334
label333:
       mov  rbx,  0
       jmp  label334
label334:
       cmp  rbx,  0
       jz  label330
label329:
       mov  r15,  qword[Sum]
       mov  rbx,  r15
       mov  r14,  qword [rbp-24]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  rbx,  r15
       mov  r14,  qword[Sum]
       mov  qword [rbp-136],  r14
       mov  r13,  qword [rbp-136]
       mov  r12,  qword [rbp-24]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [r13 + r11 * 8]
       mov  qword [rbp-144],  r10
       mov  r15,  qword [rbp-144]
       mov  r14,  qword [rbp-16]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [r15 + r13 * 8]
       mov  qword [rbp-152],  r12
       mov  r11,  qword [rbp-152]
       mov  r10,  qword [rbp-8]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [r11 + r15 * 8]
       mov  qword [rbp-160],  r14
       mov  r13,  qword [rbp-160]
       mov  r12,  qword[Mod]
       mov  r11,  r13
       sub  r11,  r12
       mov  qword [rbp-160],  r11
       mov  r10,  qword [rbp-160]
       mov  r15,  qword [rbp-8]
       mov  r14,  r15
       add  r14,  1
       mov  qword [rbx + r14 * 8],  r10
       jmp  label331
label330:
       jmp  label331
label331:
       jmp  label325
label325:
       mov  r13,  qword [rbp-16]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-16],  r12
       jmp  label324
label323:
       jmp  label318
label318:
       mov  r11,  qword [rbp-8]
       mov  rbx,  r11
       mov  r10,  rbx
       add  r10,  1
       mov  qword [rbp-8],  r10
       jmp  label317
label316:
       jmp  label311
label311:
       mov  r15,  qword [rbp-24]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-24],  r14
       jmp  label310
label309:
       add  rsp,  528
       pop  rbp
       ret  
       add  rsp,  528
       pop  rbp
       ret  
Calculate_Comb:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  240
       mov  qword [rbp-8],  0
       jmp  label337
label337:
       mov  r13,  qword [rbp-8]
       mov  r12,  qword[M]
       cmp  r13,  r12
       jg  label340
label339:
       mov  rbx,  1
       jmp  label341
label340:
       mov  rbx,  0
       jmp  label341
label341:
       cmp  rbx,  0
       jz  label336
label335:
       mov  r11,  qword[Comb]
       mov  rbx,  r11
       mov  r10,  qword [rbp-8]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  rbx,  r14
       mov  qword [rbx + 8],  1
       jmp  label338
label338:
       mov  r13,  qword [rbp-8]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-8],  r12
       jmp  label337
label336:
       mov  qword [rbp-8],  1
       jmp  label344
label344:
       mov  r11,  qword [rbp-8]
       mov  r10,  qword[M]
       cmp  r11,  r10
       jg  label347
label346:
       mov  rbx,  1
       jmp  label348
label347:
       mov  rbx,  0
       jmp  label348
label348:
       cmp  rbx,  0
       jz  label343
label342:
       mov  qword [rbp-16],  1
       jmp  label351
label351:
       mov  r15,  qword [rbp-16]
       mov  r14,  qword[C]
       cmp  r15,  r14
       jg  label354
label353:
       mov  rbx,  1
       jmp  label355
label354:
       mov  rbx,  0
       jmp  label355
label355:
       cmp  rbx,  0
       jz  label350
label349:
       mov  r13,  qword[Comb]
       mov  rbx,  r13
       mov  r12,  qword [rbp-8]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  qword [rbp-24],  r10
       mov  r15,  qword [rbp-8]
       mov  qword [rbp-32],  r15
       mov  r14,  qword [rbp-32]
       mov  r13,  r14
       sub  r13,  1
       mov  qword [rbp-32],  r13
       mov  r12,  qword[Comb]
       mov  rbx,  r12
       mov  r11,  qword [rbp-32]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  qword [rbp-40],  r15
       mov  r14,  qword [rbp-16]
       mov  rbx,  r14
       sub  rbx,  1
       mov  r13,  qword [rbp-8]
       mov  qword [rbp-48],  r13
       mov  r12,  qword [rbp-48]
       mov  r11,  r12
       sub  r11,  1
       mov  qword [rbp-48],  r11
       mov  r10,  qword[Comb]
       mov  qword [rbp-56],  r10
       mov  r15,  qword [rbp-56]
       mov  r14,  qword [rbp-48]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [r15 + r13 * 8]
       mov  qword [rbp-64],  r12
       mov  r11,  qword [rbp-40]
       mov  r10,  qword [rbp-16]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [r11 + r15 * 8]
       mov  qword [rbp-72],  r14
       mov  r13,  qword [rbp-72]
       mov  r12,  qword [rbp-64]
       mov  r11,  rbx
       add  r11,  1
       mov  r10,  qword [r12 + r11 * 8]
       mov  r15,  r13
       add  r15,  r10
       mov  qword [rbp-72],  r15
       mov  r14,  qword [rbp-72]
       mov  r13,  qword [rbp-24]
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  qword [r13 + r11 * 8],  r14
       mov  r10,  qword[Comb]
       mov  rbx,  r10
       mov  r15,  qword [rbp-8]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  r15,  qword[Mod]
       cmp  r10,  r15
       jl  label360
label359:
       mov  rbx,  1
       jmp  label361
label360:
       mov  rbx,  0
       jmp  label361
label361:
       cmp  rbx,  0
       jz  label357
label356:
       mov  r14,  qword[Comb]
       mov  rbx,  r14
       mov  r13,  qword [rbp-8]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [rbx + r12 * 8]
       mov  qword [rbp-80],  r11
       mov  r10,  qword[Comb]
       mov  rbx,  r10
       mov  r15,  qword [rbp-8]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword[Mod]
       sub  rbx,  r15
       mov  r14,  qword [rbp-80]
       mov  r13,  qword [rbp-16]
       mov  r12,  r13
       add  r12,  1
       mov  qword [r14 + r12 * 8],  rbx
       jmp  label358
label357:
       jmp  label358
label358:
       jmp  label352
label352:
       mov  r11,  qword [rbp-16]
       mov  rbx,  r11
       mov  r10,  rbx
       add  r10,  1
       mov  qword [rbp-16],  r10
       jmp  label351
label350:
       jmp  label345
label345:
       mov  r15,  qword [rbp-8]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-8],  r14
       jmp  label344
label343:
       add  rsp,  240
       pop  rbp
       ret  
       add  rsp,  240
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  992
       push  rbx
       push  rbp
       call  getInt
       pop  rbp
       pop  rbx
       mov  rbx,  rax
       mov  qword [rbp-8],  rbx
       push  rbx
       push  rbp
       call  init
       pop  rbp
       pop  rbx
       mov  r13,  qword[fn]
       mov  rbx,  r13
       mov  qword [rbx + 16],  2
       mov  r12,  qword[fc]
       mov  rbx,  r12
       mov  qword [rbx + 16],  3
       mov  r11,  qword[fm]
       mov  rbx,  r11
       mov  r10,  qword [rbx + 16]
       mov  rbx,  r10
       mov  qword [rbx + 16],  3
       mov  r15,  qword[fm]
       mov  rbx,  r15
       mov  r14,  qword [rbx + 16]
       mov  rbx,  r14
       mov  qword [rbx + 24],  4
       mov  r13,  qword[fn]
       mov  rbx,  r13
       mov  qword [rbx + 24],  3
       mov  r12,  qword[fc]
       mov  rbx,  r12
       mov  qword [rbx + 24],  3
       mov  r11,  qword[fm]
       mov  rbx,  r11
       mov  r10,  qword [rbx + 24]
       mov  rbx,  r10
       mov  qword [rbx + 16],  3
       mov  r15,  qword[fm]
       mov  rbx,  r15
       mov  r14,  qword [rbx + 24]
       mov  rbx,  r14
       mov  qword [rbx + 24],  4
       mov  r13,  qword[fm]
       mov  rbx,  r13
       mov  r12,  qword [rbx + 24]
       mov  rbx,  r12
       mov  qword [rbx + 32],  4
       mov  r11,  qword[fn]
       mov  rbx,  r11
       mov  qword [rbx + 32],  4
       mov  r10,  qword[fc]
       mov  rbx,  r10
       mov  qword [rbx + 32],  4
       mov  r15,  qword[fm]
       mov  rbx,  r15
       mov  r14,  qword [rbx + 32]
       mov  rbx,  r14
       mov  qword [rbx + 16],  5
       mov  r13,  qword[fm]
       mov  rbx,  r13
       mov  r12,  qword [rbx + 32]
       mov  rbx,  r12
       mov  qword [rbx + 24],  7
       mov  r11,  qword[fm]
       mov  rbx,  r11
       mov  r10,  qword [rbx + 32]
       mov  rbx,  r10
       mov  qword [rbx + 32],  8
       mov  r15,  qword[fm]
       mov  rbx,  r15
       mov  r14,  qword [rbx + 32]
       mov  rbx,  r14
       mov  qword [rbx + 40],  9
       mov  qword[C],  4
       mov  qword[M],  9
       mov  qword[N],  4
       mov  qword[Mod],  10007
       push  rbx
       push  rbp
       call  Calculate_G
       pop  rbp
       pop  rbx
       push  rbx
       push  rbp
       call  Calculate_Comb
       pop  rbp
       pop  rbx
       mov  qword [rbp-16],  1
       jmp  label364
label364:
       mov  r13,  qword [rbp-16]
       mov  r12,  qword [rbp-8]
       cmp  r13,  r12
       jg  label367
label366:
       mov  rbx,  1
       jmp  label368
label367:
       mov  rbx,  0
       jmp  label368
label368:
       cmp  rbx,  0
       jz  label363
label362:
       mov  r11,  qword[fn]
       mov  rbx,  r11
       mov  r10,  qword [rbp-16]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  qword [rbp-24],  r14
       mov  r13,  qword[fc]
       mov  rbx,  r13
       mov  r12,  qword [rbp-16]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  qword [rbp-32],  r10
       mov  qword [rbp-40],  1
       jmp  label371
label371:
       mov  r15,  qword [rbp-40]
       mov  r14,  qword [rbp-24]
       cmp  r15,  r14
       jg  label374
label373:
       mov  rbx,  1
       jmp  label375
label374:
       mov  rbx,  0
       jmp  label375
label375:
       cmp  rbx,  0
       jz  label370
label369:
       mov  r13,  qword[m]
       mov  qword [rbp-48],  r13
       mov  r12,  qword[fm]
       mov  rbx,  r12
       mov  r11,  qword [rbp-16]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  rbx,  r15
       mov  r14,  qword [rbp-40]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  r11,  qword [rbp-48]
       mov  r10,  qword [rbp-40]
       mov  r15,  r10
       add  r15,  1
       mov  qword [r11 + r15 * 8],  r12
       jmp  label372
label372:
       mov  r14,  qword [rbp-40]
       mov  rbx,  r14
       mov  r13,  rbx
       add  r13,  1
       mov  qword [rbp-40],  r13
       jmp  label371
label370:
       mov  r12,  qword [rbp-24]
       cmp  r12,  1
       jne  label380
label379:
       mov  rbx,  1
       jmp  label381
label380:
       mov  rbx,  0
       jmp  label381
label381:
       cmp  rbx,  0
       jz  label377
label376:
       mov  r11,  qword[m]
       mov  qword [rbp-56],  r11
       mov  r10,  qword[Comb]
       mov  rbx,  r10
       mov  r15,  qword [rbp-56]
       mov  r14,  qword [r15 + 16]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       push  rbx
       push  rbp
       mov  r11,  qword [rbp-32]
       mov  r10,  r11
       add  r10,  1
       mov  rdi,  qword [rbx + r10 * 8]
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
       jmp  label378
label377:
       mov  qword [rbp-64],  0
       mov  rbx,  0
       mov  qword [rbp-72],  0
       mov  qword [rbp-80],  1
       jmp  label384
label384:
       mov  r15,  qword[m]
       mov  rbx,  r15
       mov  r14,  qword [rbp-80]
       mov  r13,  qword [rbx + 16]
       cmp  r14,  r13
       jg  label387
label386:
       mov  rbx,  1
       jmp  label388
label387:
       mov  rbx,  0
       jmp  label388
label388:
       cmp  rbx,  0
       jz  label383
label382:
       mov  r12,  qword[m]
       mov  qword [rbp-88],  r12
       mov  r11,  qword[m]
       mov  rbx,  r11
       mov  r10,  qword [rbx + 16]
       mov  rbx,  r10
       mov  r15,  qword [rbp-80]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r15
       mov  rbx,  rax
       mov  r14,  qword [rbp-88]
       mov  r13,  qword [r14 + 16]
       mov  qword [rbp-96],  r13
       mov  r12,  qword [rbp-96]
       mov  rax,  r12
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-96],  rax
       mov  r10,  qword [rbp-96]
       mov  qword [rbp-104],  r10
       mov  qword [rbp-112],  2
       jmp  label391
label391:
       mov  r15,  qword [rbp-112]
       mov  r14,  qword [rbp-24]
       cmp  r15,  r14
       jg  label394
label393:
       mov  rbx,  1
       jmp  label395
label394:
       mov  rbx,  0
       jmp  label395
label395:
       cmp  rbx,  0
       jz  label390
label389:
       mov  r13,  qword[m]
       mov  qword [rbp-120],  r13
       mov  r12,  qword[m]
       mov  rbx,  r12
       mov  r11,  qword [rbp-112]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  rbx,  r15
       mov  r14,  qword [rbp-80]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r14
       mov  rbx,  rax
       mov  r13,  qword [rbp-120]
       mov  r12,  qword [rbp-112]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [r13 + r11 * 8]
       mov  qword [rbp-128],  r10
       mov  r15,  qword [rbp-128]
       mov  rax,  r15
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-128],  rax
       mov  r13,  qword [rbp-128]
       mov  qword [rbp-136],  r13
       mov  r12,  qword [rbp-136]
       mov  r11,  qword [rbp-104]
       cmp  r12,  r11
       jge  label400
label399:
       mov  rbx,  1
       jmp  label401
label400:
       mov  rbx,  0
       jmp  label401
label401:
       cmp  rbx,  0
       jz  label397
label396:
       mov  r10,  qword [rbp-136]
       mov  qword [rbp-104],  r10
       jmp  label398
label397:
       jmp  label398
label398:
       jmp  label392
label392:
       mov  r15,  qword [rbp-112]
       mov  rbx,  r15
       mov  r14,  rbx
       add  r14,  1
       mov  qword [rbp-112],  r14
       jmp  label391
label390:
       mov  r13,  qword[m]
       mov  rbx,  r13
       mov  r12,  qword [rbx + 16]
       mov  r11,  qword [rbp-104]
       cmp  r12,  r11
       jge  label406
label405:
       mov  rbx,  1
       jmp  label407
label406:
       mov  rbx,  0
       jmp  label407
label407:
       cmp  rbx,  0
       jz  label403
label402:
       mov  r10,  qword[m]
       mov  rbx,  r10
       mov  r15,  qword [rbx + 16]
       mov  qword [rbp-104],  r15
       jmp  label404
label403:
       jmp  label404
label404:
       mov  r14,  qword [rbp-104]
       mov  qword [rbp-80],  r14
       mov  r13,  qword[b]
       mov  rbx,  r13
       mov  qword [rbx + 8],  1
       mov  qword [rbp-112],  1
       jmp  label410
label410:
       mov  r12,  qword [rbp-112]
       mov  r11,  qword [rbp-24]
       cmp  r12,  r11
       jg  label413
label412:
       mov  rbx,  1
       jmp  label414
label413:
       mov  rbx,  0
       jmp  label414
label414:
       cmp  rbx,  0
       jz  label409
label408:
       mov  r10,  qword[m]
       mov  rbx,  r10
       mov  r15,  qword [rbp-112]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  rbx,  r13
       mov  r12,  qword [rbp-80]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r12
       mov  rbx,  rax
       mov  r11,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r11
       mov  rbx,  rdx
       mov  qword [rbp-144],  rbx
       mov  r10,  qword [rbp-144]
       mov  qword [rbp-152],  r10
       mov  r15,  qword [rbp-152]
       mov  r14,  r15
       add  r14,  1
       mov  qword [rbp-152],  r14
       mov  r13,  qword [rbp-144]
       mov  rbx,  r13
       mov  r12,  qword [rbp-152]
       imul  rbx,  r12
       mov  rbx,  rbx
       mov  rax,  rbx
       mov  r11,  2
       mov  rdx,  0
       idiv  r11
       mov  rbx,  rax
       mov  r10,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r10
       mov  rbx,  rdx
       mov  qword [rbp-160],  rbx
       mov  r15,  qword[m]
       mov  rbx,  r15
       mov  r14,  qword [rbp-112]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword [rbp-144]
       imul  rbx,  r11
       mov  rbx,  rbx
       mov  r10,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r10
       mov  rbx,  rdx
       mov  qword [rbp-168],  rbx
       mov  qword [rbp-176],  0
       jmp  label417
label417:
       mov  r15,  qword [rbp-176]
       mov  r14,  qword [rbp-112]
       cmp  r15,  r14
       jge  label420
label419:
       mov  rbx,  1
       jmp  label421
label420:
       mov  rbx,  0
       jmp  label421
label421:
       cmp  rbx,  0
       jz  label416
label415:
       mov  r13,  qword [rbp-176]
       mov  qword [rbp-184],  r13
       mov  r12,  qword [rbp-184]
       mov  r11,  r12
       add  r11,  1
       mov  qword [rbp-184],  r11
       mov  r10,  qword[res]
       mov  qword [rbp-192],  r10
       mov  r15,  qword[b]
       mov  rbx,  r15
       mov  r14,  qword[Mod]
       mov  qword [rbp-200],  r14
       mov  r13,  qword [rbp-200]
       mov  r12,  qword [rbp-160]
       mov  r11,  r13
       sub  r11,  r12
       mov  qword [rbp-200],  r11
       mov  r10,  qword [rbp-176]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  rbx,  r14
       mov  r13,  qword [rbp-200]
       imul  rbx,  r13
       mov  rbx,  rbx
       mov  r12,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r12
       mov  rbx,  rdx
       mov  r11,  qword [rbp-192]
       mov  r10,  qword [rbp-184]
       mov  r15,  r10
       add  r15,  1
       mov  qword [r11 + r15 * 8],  rbx
       jmp  label418
label418:
       mov  r14,  qword [rbp-176]
       mov  rbx,  r14
       mov  r13,  rbx
       add  r13,  1
       mov  qword [rbp-176],  r13
       jmp  label417
label416:
       mov  r12,  qword[res]
       mov  rbx,  r12
       mov  qword [rbx + 8],  0
       mov  qword [rbp-176],  0
       jmp  label424
label424:
       mov  r11,  qword [rbp-176]
       mov  r10,  qword [rbp-112]
       cmp  r11,  r10
       jge  label427
label426:
       mov  rbx,  1
       jmp  label428
label427:
       mov  rbx,  0
       jmp  label428
label428:
       cmp  rbx,  0
       jz  label423
label422:
       mov  r15,  qword[res]
       mov  qword [rbp-208],  r15
       mov  r14,  qword[res]
       mov  qword [rbp-216],  r14
       mov  r13,  qword[b]
       mov  qword [rbp-224],  r13
       mov  r12,  qword [rbp-168]
       mov  rbx,  r12
       mov  r11,  qword [rbp-224]
       mov  r10,  qword [rbp-176]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [r11 + r15 * 8]
       imul  rbx,  r14
       mov  r13,  qword [rbp-216]
       mov  r12,  qword [rbp-176]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [r13 + r11 * 8]
       mov  qword [rbp-232],  r10
       mov  r15,  qword [rbp-232]
       mov  r14,  r15
       add  r14,  rbx
       mov  qword [rbp-232],  r14
       mov  r13,  qword [rbp-232]
       mov  rbx,  r13
       mov  r12,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r12
       mov  rbx,  rdx
       mov  r11,  qword [rbp-208]
       mov  r10,  qword [rbp-176]
       mov  r15,  r10
       add  r15,  1
       mov  qword [r11 + r15 * 8],  rbx
       jmp  label425
label425:
       mov  r14,  qword [rbp-176]
       mov  rbx,  r14
       mov  r13,  rbx
       add  r13,  1
       mov  qword [rbp-176],  r13
       jmp  label424
label423:
       mov  qword [rbp-176],  0
       jmp  label431
label431:
       mov  r12,  qword [rbp-176]
       mov  r11,  qword [rbp-112]
       cmp  r12,  r11
       jg  label434
label433:
       mov  rbx,  1
       jmp  label435
label434:
       mov  rbx,  0
       jmp  label435
label435:
       cmp  rbx,  0
       jz  label430
label429:
       mov  r10,  qword[b]
       mov  qword [rbp-240],  r10
       mov  r15,  qword[res]
       mov  rbx,  r15
       mov  r14,  qword [rbp-176]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  r11,  qword [rbp-240]
       mov  r10,  qword [rbp-176]
       mov  r15,  r10
       add  r15,  1
       mov  qword [r11 + r15 * 8],  r12
       jmp  label432
label432:
       mov  r14,  qword [rbp-176]
       mov  rbx,  r14
       mov  r13,  rbx
       add  r13,  1
       mov  qword [rbp-176],  r13
       jmp  label431
label430:
       jmp  label411
label411:
       mov  r12,  qword [rbp-112]
       mov  rbx,  r12
       mov  r11,  rbx
       add  r11,  1
       mov  qword [rbp-112],  r11
       jmp  label410
label409:
       mov  qword [rbp-112],  0
       jmp  label438
label438:
       mov  r10,  qword [rbp-112]
       mov  r15,  qword [rbp-24]
       cmp  r10,  r15
       jg  label441
label440:
       mov  rbx,  1
       jmp  label442
label441:
       mov  rbx,  0
       jmp  label442
label442:
       cmp  rbx,  0
       jz  label437
label436:
       mov  r14,  qword[b]
       mov  qword [rbp-248],  r14
       mov  r13,  qword[Sum]
       mov  rbx,  r13
       mov  r12,  qword [rbp-112]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  rbx,  r10
       mov  r15,  qword [rbp-80]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  qword [rbp-256],  r13
       mov  r12,  qword[Sum]
       mov  rbx,  r12
       mov  r11,  qword [rbp-112]
       mov  r10,  r11
       add  r10,  1
       mov  r15,  qword [rbx + r10 * 8]
       mov  rbx,  r15
       mov  r14,  qword [rbp-72]
       mov  r13,  r14
       add  r13,  1
       mov  r12,  qword [rbx + r13 * 8]
       mov  rbx,  r12
       mov  r11,  qword [rbp-256]
       mov  r10,  qword [rbp-32]
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [r11 + r15 * 8]
       mov  qword [rbp-264],  r14
       mov  r13,  qword [rbp-264]
       mov  r12,  qword [rbp-32]
       mov  r11,  r12
       add  r11,  1
       mov  r10,  qword [rbx + r11 * 8]
       mov  r15,  r13
       sub  r15,  r10
       mov  qword [rbp-264],  r15
       mov  r14,  qword [rbp-248]
       mov  r13,  qword [rbp-112]
       mov  r12,  r13
       add  r12,  1
       mov  r11,  qword [r14 + r12 * 8]
       mov  rbx,  r11
       mov  r10,  qword [rbp-264]
       imul  rbx,  r10
       mov  r15,  qword [rbp-64]
       mov  qword [rbp-272],  r15
       mov  r14,  qword [rbp-272]
       mov  r13,  r14
       add  r13,  rbx
       mov  qword [rbp-272],  r13
       mov  r12,  qword [rbp-272]
       mov  rbx,  r12
       mov  r11,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r11
       mov  rbx,  rdx
       mov  qword [rbp-64],  rbx
       jmp  label439
label439:
       mov  r10,  qword [rbp-112]
       mov  rbx,  r10
       mov  r15,  rbx
       add  r15,  1
       mov  qword [rbp-112],  r15
       jmp  label438
label437:
       mov  r14,  qword [rbp-80]
       mov  qword [rbp-72],  r14
       jmp  label385
label385:
       mov  r13,  qword [rbp-80]
       mov  rbx,  r13
       mov  r12,  rbx
       add  r12,  1
       mov  qword [rbp-80],  r12
       jmp  label384
label383:
       mov  r11,  qword [rbp-64]
       cmp  r11,  0
       jge  label447
label446:
       mov  rbx,  1
       jmp  label448
label447:
       mov  rbx,  0
       jmp  label448
label448:
       cmp  rbx,  0
       jz  label444
label443:
       mov  r10,  qword [rbp-64]
       mov  rbx,  r10
       mov  r15,  qword[Mod]
       add  rbx,  r15
       mov  qword [rbp-64],  rbx
       jmp  label445
label444:
       jmp  label445
label445:
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-64]
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
       jmp  label378
label378:
       jmp  label365
label365:
       mov  r14,  qword [rbp-16]
       mov  rbx,  r14
       mov  r13,  rbx
       add  r13,  1
       mov  qword [rbp-16],  r13
       jmp  label364
label363:
       mov  rax,  0
       add  rsp,  992
       pop  rbp
       ret  
       add  rsp,  992
       pop  rbp
       ret  

section .data

section .bss

Mod:       resq  1
p:       resq  1
res:       resq  1
ksm:       resq  1
prime:       resq  1
tot:       resq  1
v:       resq  1
q:       resq  1
g:       resq  1
Sum:       resq  1
m:       resq  1
b:       resq  1
Comb:       resq  1
C:       resq  1
M:       resq  1
N:       resq  1
fn:       resq  1
fc:       resq  1
fm:       resq  1


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
