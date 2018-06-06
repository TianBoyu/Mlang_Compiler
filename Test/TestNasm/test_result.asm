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
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  6
       mov  r10,  0
       mov  qword[g],  rbx
       mov  r12,  0
       jmp  label4
label4:
       cmp  r12,  6
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
       mov  r15,  qword[g]
       mov  rbx,  r15
       mov  rdi,  800016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r11,  rax
       mov  qword [r11 + 0],  100001
       mov  r10,  0
       mov  r8,  r12
       add  r8,  1
       mov  qword [rbx + r8 * 8],  r11
       mov  r11,  0
       jmp  label13
label13:
       cmp  r11,  100001
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
       mov  r9,  qword[g]
       mov  rbx,  r9
       mov  rcx,  r12
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  r10,  rdi
       mov  rdi,  128
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  15
       mov  r15,  r11
       add  r15,  1
       mov  qword [r10 + r15 * 8],  rbx
       mov  r10,  0
       jmp  label20
label20:
       cmp  r10,  15
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
       mov  r8,  qword[g]
       mov  rbx,  r8
       mov  r9,  r12
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  rbx,  rcx
       mov  rdi,  r11
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  r10
       add  r8,  1
       mov  qword [rbx + r8 * 8],  0
       jmp  label21
label21:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
       jmp  label20
label19:
       jmp  label14
label14:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label13
label12:
       jmp  label5
label5:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label4
label3:
       mov  rdi,  56
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  6
       mov  r10,  0
       mov  qword[Sum],  rbx
       mov  r12,  0
       jmp  label29
label29:
       cmp  r12,  6
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
       mov  r9,  qword[Sum]
       mov  rbx,  r9
       mov  rdi,  800016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r11,  rax
       mov  qword [r11 + 0],  100001
       mov  r10,  0
       mov  rcx,  r12
       add  rcx,  1
       mov  qword [rbx + rcx * 8],  r11
       mov  r11,  0
       jmp  label38
label38:
       cmp  r11,  100001
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
       mov  rdi,  qword[Sum]
       mov  rbx,  rdi
       mov  r15,  r12
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  r10,  r8
       mov  rdi,  128
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  15
       mov  r9,  r11
       add  r9,  1
       mov  qword [r10 + r9 * 8],  rbx
       mov  r10,  0
       jmp  label45
label45:
       cmp  r10,  15
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
       mov  rcx,  qword[Sum]
       mov  rbx,  rcx
       mov  rdi,  r12
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  r10
       add  rcx,  1
       mov  qword [rbx + rcx * 8],  0
       jmp  label46
label46:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
       jmp  label45
label44:
       jmp  label39
label39:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label38
label37:
       jmp  label30
label30:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label29
label28:
       mov  rdi,  8016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  r10,  0
       mov  qword[fm],  rbx
       mov  r12,  0
       jmp  label54
label54:
       cmp  r12,  1001
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
       mov  rdi,  qword[fm]
       mov  rbx,  rdi
       mov  rdi,  112
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  13
       mov  r15,  r12
       add  r15,  1
       mov  qword [rbx + r15 * 8],  r10
       mov  r11,  0
       jmp  label61
label61:
       cmp  r11,  13
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
       mov  r8,  qword[fm]
       mov  rbx,  r8
       mov  r9,  r12
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  rbx,  rcx
       mov  rdi,  r11
       add  rdi,  1
       mov  qword [rbx + rdi * 8],  0
       jmp  label62
label62:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label61
label60:
       jmp  label55
label55:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label54
label53:
       mov  rdi,  800016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  100001
       mov  rbx,  0
       mov  qword[ksm],  r10
       mov  r12,  0
       jmp  label70
label70:
       cmp  r12,  100001
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
       mov  r15,  qword[ksm]
       mov  rbx,  r15
       mov  rdi,  176
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  21
       mov  r8,  r12
       add  r8,  1
       mov  qword [rbx + r8 * 8],  r10
       mov  r11,  0
       jmp  label77
label77:
       cmp  r11,  21
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
       mov  r9,  qword[ksm]
       mov  rbx,  r9
       mov  rcx,  r12
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  rbx,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  qword [rbx + r15 * 8],  0
       jmp  label78
label78:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label77
label76:
       jmp  label71
label71:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label70
label69:
       mov  rdi,  176
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  21
       mov  rbx,  0
       mov  qword[p],  r10
       mov  r12,  0
       jmp  label86
label86:
       cmp  r12,  21
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
       mov  r8,  qword[p]
       mov  rbx,  r8
       mov  rdi,  176
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  21
       mov  r9,  r12
       add  r9,  1
       mov  qword [rbx + r9 * 8],  r10
       mov  r11,  0
       jmp  label93
label93:
       cmp  r11,  21
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
       mov  rcx,  qword[p]
       mov  rbx,  rcx
       mov  rdi,  r12
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  r11
       add  r8,  1
       mov  qword [rbx + r8 * 8],  0
       jmp  label94
label94:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label93
label92:
       jmp  label87
label87:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label86
label85:
       mov  rdi,  176
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  21
       mov  rbx,  0
       mov  qword[q],  r10
       mov  r12,  0
       jmp  label102
label102:
       cmp  r12,  21
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
       mov  r9,  qword[q]
       mov  rbx,  r9
       mov  rdi,  800016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  100001
       mov  rcx,  r12
       add  rcx,  1
       mov  qword [rbx + rcx * 8],  r10
       mov  r11,  0
       jmp  label109
label109:
       cmp  r11,  100001
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
       mov  rdi,  qword[q]
       mov  rbx,  rdi
       mov  r15,  r12
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  r9,  r11
       add  r9,  1
       mov  qword [rbx + r9 * 8],  0
       jmp  label110
label110:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label109
label108:
       jmp  label103
label103:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label102
label101:
       mov  rdi,  800016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  100001
       mov  rbx,  0
       mov  qword[Comb],  r10
       mov  r12,  0
       jmp  label118
label118:
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
       mov  rcx,  qword[Comb]
       mov  rbx,  rcx
       mov  rdi,  176
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  r10,  rax
       mov  qword [r10 + 0],  21
       mov  rdi,  r12
       add  rdi,  1
       mov  qword [rbx + rdi * 8],  r10
       mov  r11,  0
       jmp  label125
label125:
       cmp  r11,  21
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
       mov  r15,  qword[Comb]
       mov  rbx,  r15
       mov  r8,  r12
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  r11
       add  rcx,  1
       mov  qword [rbx + rcx * 8],  0
       jmp  label126
label126:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label125
label124:
       jmp  label119
label119:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label118
label117:
       mov  rdi,  8016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[fn],  rbx
       mov  r12,  0
       jmp  label132
label132:
       cmp  r12,  1001
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
       mov  rdi,  qword[fn]
       mov  rbx,  rdi
       mov  r15,  r12
       add  r15,  1
       mov  qword [rbx + r15 * 8],  0
       jmp  label133
label133:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label132
label131:
       mov  rdi,  8016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[fc],  rbx
       mov  r12,  0
       jmp  label139
label139:
       cmp  r12,  1001
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
       mov  r8,  qword[fc]
       mov  rbx,  r8
       mov  r9,  r12
       add  r9,  1
       mov  qword [rbx + r9 * 8],  0
       jmp  label140
label140:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label139
label138:
       mov  rdi,  8016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[m],  rbx
       mov  r12,  0
       jmp  label146
label146:
       cmp  r12,  1001
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
       mov  rcx,  qword[m]
       mov  rbx,  rcx
       mov  rdi,  r12
       add  rdi,  1
       mov  qword [rbx + rdi * 8],  0
       jmp  label147
label147:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label146
label145:
       mov  rdi,  8016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[res],  rbx
       mov  r12,  0
       jmp  label153
label153:
       cmp  r12,  1001
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
       mov  r15,  qword[res]
       mov  rbx,  r15
       mov  r8,  r12
       add  r8,  1
       mov  qword [rbx + r8 * 8],  0
       jmp  label154
label154:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label153
label152:
       mov  rdi,  8016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  1001
       mov  qword[b],  rbx
       mov  r12,  0
       jmp  label160
label160:
       cmp  r12,  1001
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
       mov  r9,  qword[b]
       mov  rbx,  r9
       mov  rcx,  r12
       add  rcx,  1
       mov  qword [rbx + rcx * 8],  0
       jmp  label161
label161:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label160
label159:
       mov  rdi,  800016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  100001
       mov  qword[v],  rbx
       mov  r12,  0
       jmp  label167
label167:
       cmp  r12,  100001
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
       mov  rdi,  qword[v]
       mov  rbx,  rdi
       mov  r15,  r12
       add  r15,  1
       mov  qword [rbx + r15 * 8],  0
       jmp  label168
label168:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
       jmp  label167
label166:
       mov  rdi,  800016
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       call  malloc
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbx + 0],  100001
       mov  qword[prime],  rbx
       mov  r12,  0
       jmp  label174
label174:
       cmp  r12,  100001
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
       mov  r8,  qword[prime]
       mov  rbx,  r8
       mov  r9,  r12
       add  r9,  1
       mov  qword [rbx + r9 * 8],  0
       jmp  label175
label175:
       mov  rbx,  r12
       mov  r12,  rbx
       add  r12,  1
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
       mov  r10,  rdi
       mov  r12,  rsi
       cmp  r12,  0
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
       mov  rbx,  r10
       mov  rcx,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  rcx
       mov  rbx,  rdx
       mov  rax,  rbx
       add  rsp,  144
       pop  rbp
       ret  
       jmp  label187
label186:
       jmp  label187
label187:
       mov  rbx,  r12
       mov  rcx,  1
       sar  rbx,  cl
       push  rbp
       push  rbx
       push  r10
       push  r11
       push  r12
       mov  rdi,  r10
       mov  rsi,  rbx
       call  Ksm
       pop  r12
       pop  r11
       pop  r10
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  r11,  rbx
       mov  rbx,  r12
       mov  rax,  rbx
       mov  rdi,  2
       mov  rdx,  0
       idiv  rdi
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
       mov  rbx,  r11
       imul  rbx,  r11
       mov  rbx,  rbx
       mov  r15,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r15
       mov  rbx,  rdx
       mov  rbx,  rbx
       imul  rbx,  r10
       mov  rbx,  rbx
       mov  r8,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r8
       mov  rbx,  rdx
       mov  rax,  rbx
       add  rsp,  144
       pop  rbp
       ret  
       jmp  label193
label192:
       mov  rbx,  r11
       imul  rbx,  r11
       mov  rbx,  rbx
       mov  r9,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r9
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
       mov  rcx,  qword[p]
       mov  rbx,  rcx
       mov  rdi,  qword [rbx + 8]
       mov  rbx,  rdi
       mov  qword [rbx + 8],  1
       mov  r15,  qword[p]
       mov  rbx,  r15
       mov  r8,  qword [rbx + 16]
       mov  rbx,  r8
       mov  qword [rbx + 16],  1
       mov  r9,  qword[p]
       mov  rbx,  r9
       mov  rcx,  qword [rbx + 16]
       mov  r10,  rcx
       mov  rdi,  qword[Mod]
       mov  rbx,  rdi
       sub  rbx,  1
       mov  qword [r10 + 8],  rbx
       mov  r10,  2
       jmp  label199
label199:
       mov  r15,  qword[C]
       mov  rbx,  r15
       sub  rbx,  2
       cmp  r10,  rbx
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
       mov  r8,  qword[Mod]
       mov  rbx,  r8
       sub  rbx,  2
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       mov  rdi,  r10
       mov  rsi,  rbx
       call  Ksm
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbp-8],  rbx
       mov  r11,  0
       jmp  label206
label206:
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
       mov  r12,  r11
       add  r12,  1
       mov  r9,  qword[p]
       mov  rbx,  r9
       mov  rcx,  r10
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  r13,  rdi
       mov  rbx,  r10
       sub  rbx,  1
       mov  r15,  qword[p]
       mov  r14,  r15
       mov  r8,  rbx
       add  r8,  1
       mov  r9,  qword [r14 + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  r11
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  r15,  r12
       add  r15,  1
       mov  qword [r13 + r15 * 8],  rdi
       jmp  label207
label207:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label206
label205:
       mov  r11,  0
       jmp  label213
label213:
       cmp  r11,  r10
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
       mov  r8,  qword[p]
       mov  rbx,  r8
       mov  r9,  r10
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  r12,  rcx
       mov  rdi,  qword[p]
       mov  rbx,  rdi
       mov  r15,  r10
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  r14,  r10
       sub  r14,  1
       mov  r9,  qword[p]
       mov  r13,  r9
       mov  rcx,  r14
       add  rcx,  1
       mov  rdi,  qword [r13 + rcx * 8]
       mov  r13,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  r8,  qword [r13 + r15 * 8]
       mov  r13,  r8
       imul  r13,  r10
       mov  r13,  r13
       mov  r9,  qword[Mod]
       mov  rax,  r13
       mov  rdx,  0
       idiv  r9
       mov  r13,  rdx
       mov  rcx,  r11
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  rbx,  rdi
       sub  rbx,  r13
       mov  rbx,  rbx
       mov  r15,  qword[Mod]
       add  rbx,  r15
       mov  rbx,  rbx
       mov  r8,  qword [rbp-8]
       imul  rbx,  r8
       mov  rbx,  rbx
       mov  r9,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r9
       mov  rbx,  rdx
       mov  rcx,  r11
       add  rcx,  1
       mov  qword [r12 + rcx * 8],  rbx
       jmp  label214
label214:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label213
label212:
       jmp  label200
label200:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
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
       mov  r10,  rdi
       mov  qword[tot],  0
       mov  rdi,  qword[q]
       mov  rbx,  rdi
       mov  r15,  r10
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  qword [rbx + 16],  1
       mov  qword [rbp-8],  0
       jmp  label220
label220:
       mov  r9,  qword [rbp-8]
       cmp  r9,  100001
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
       mov  rcx,  qword[v]
       mov  rbx,  rcx
       mov  rdi,  qword [rbp-8]
       mov  r15,  rdi
       add  r15,  1
       mov  qword [rbx + r15 * 8],  0
       jmp  label221
label221:
       mov  r8,  qword [rbp-8]
       mov  rbx,  r8
       mov  r9,  rbx
       add  r9,  1
       mov  qword [rbp-8],  r9
       jmp  label220
label219:
       mov  qword [rbp-8],  2
       jmp  label227
label227:
       mov  rcx,  qword [rbp-8]
       mov  rdi,  qword[M]
       cmp  rcx,  rdi
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
       mov  r15,  qword[v]
       mov  rbx,  r15
       mov  r8,  qword [rbp-8]
       mov  r9,  r8
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       cmp  rcx,  0
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
       mov  rdi,  qword[tot]
       mov  r15,  rdi
       add  r15,  1
       mov  qword[tot],  r15
       mov  r8,  qword[prime]
       mov  rbx,  r8
       mov  r9,  qword [rbp-8]
       mov  rcx,  qword[tot]
       mov  rdi,  rcx
       add  rdi,  1
       mov  qword [rbx + rdi * 8],  r9
       mov  r15,  qword[q]
       mov  rbx,  r15
       mov  r8,  r10
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r11,  r9
       mov  rcx,  qword[ksm]
       mov  rbx,  rcx
       mov  rdi,  qword [rbp-8]
       mov  r15,  rdi
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  r9,  r10
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  rbx,  rcx
       mov  rdi,  qword[Mod]
       add  rbx,  rdi
       mov  rbx,  rbx
       sub  rbx,  1
       mov  rbx,  rbx
       mov  r15,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r15
       mov  rbx,  rdx
       mov  r8,  qword [rbp-8]
       mov  r9,  r8
       add  r9,  1
       mov  qword [r11 + r9 * 8],  rbx
       jmp  label234
label233:
       jmp  label234
label234:
       mov  r11,  1
       jmp  label240
label240:
       mov  rcx,  qword[tot]
       cmp  r11,  rcx
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
       mov  rdi,  qword[prime]
       mov  rbx,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  r9,  qword [rbp-8]
       imul  rbx,  r9
       mov  rcx,  qword[M]
       cmp  rbx,  rcx
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
       mov  rdi,  qword[prime]
       mov  rbx,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  r9,  qword [rbp-8]
       imul  rbx,  r9
       mov  rcx,  qword[v]
       mov  r12,  rcx
       mov  rdi,  rbx
       add  rdi,  1
       mov  qword [r12 + rdi * 8],  1
       mov  r15,  qword[prime]
       mov  r12,  r15
       mov  r8,  qword [rbp-8]
       mov  rbx,  r8
       mov  r9,  r11
       add  r9,  1
       mov  rcx,  qword [r12 + r9 * 8]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  rcx
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
       mov  rdi,  qword[prime]
       mov  rbx,  rdi
       mov  r15,  qword [rbp-8]
       mov  r12,  r15
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       imul  r12,  r9
       mov  rcx,  qword[q]
       mov  rbx,  rcx
       mov  rdi,  r10
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  qword [rbp-16],  r15
       mov  r8,  qword[q]
       mov  rbx,  r8
       mov  r9,  r10
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  r13,  rcx
       mov  rdi,  qword[prime]
       mov  r14,  rdi
       mov  r15,  qword[ksm]
       mov  rbx,  r15
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [r14 + r8 * 8]
       mov  rcx,  r9
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  rbx,  rdi
       mov  r15,  qword [rbp-8]
       mov  r8,  r15
       add  r8,  1
       mov  r9,  qword [r13 + r8 * 8]
       mov  r11,  r9
       mov  rcx,  r10
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       imul  r11,  rdi
       mov  rbx,  r11
       mov  r15,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r15
       mov  rbx,  rdx
       mov  r8,  qword [rbp-16]
       mov  r9,  r12
       add  r9,  1
       mov  qword [r8 + r9 * 8],  rbx
       jmp  label239
       jmp  label255
label254:
       mov  rcx,  qword[prime]
       mov  rbx,  rcx
       mov  rdi,  qword [rbp-8]
       mov  r12,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       imul  r12,  r8
       mov  r9,  qword[q]
       mov  rbx,  r9
       mov  rcx,  r10
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  rbx,  rdi
       mov  r15,  qword[q]
       mov  r13,  r15
       mov  r8,  r10
       add  r8,  1
       mov  r9,  qword [r13 + r8 * 8]
       mov  r13,  r9
       mov  rcx,  qword[prime]
       mov  qword [rbp-24],  rcx
       mov  rdi,  qword[q]
       mov  r14,  rdi
       mov  r15,  r10
       add  r15,  1
       mov  r8,  qword [r14 + r15 * 8]
       mov  r14,  r8
       mov  r9,  qword [rbp-8]
       mov  rcx,  r9
       add  rcx,  1
       mov  rdi,  qword [r13 + rcx * 8]
       mov  r13,  rdi
       mov  r15,  qword [rbp-24]
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [r15 + r8 * 8]
       mov  rcx,  r9
       add  rcx,  1
       mov  rdi,  qword [r14 + rcx * 8]
       imul  r13,  rdi
       mov  r13,  r13
       mov  r15,  qword[Mod]
       mov  rax,  r13
       mov  rdx,  0
       idiv  r15
       mov  r13,  rdx
       mov  r8,  r12
       add  r8,  1
       mov  qword [rbx + r8 * 8],  r13
       jmp  label255
label255:
       jmp  label241
label241:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label240
label239:
       jmp  label228
label228:
       mov  r9,  qword [rbp-8]
       mov  rbx,  r9
       mov  rcx,  rbx
       add  rcx,  1
       mov  qword [rbp-8],  rcx
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
       mov  r10,  0
       jmp  label261
label261:
       mov  rdi,  qword[C]
       mov  rbx,  rdi
       sub  rbx,  2
       cmp  r10,  rbx
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
       push  rbp
       push  rbx
       push  r10
       mov  rdi,  r10
       call  Euler
       pop  r10
       pop  rbx
       pop  rbp
       jmp  label262
label262:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
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
       mov  r10,  1
       jmp  label268
label268:
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
       mov  r8,  qword[ksm]
       mov  rbx,  r8
       mov  r9,  r10
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  rbx,  rcx
       mov  qword [rbx + 8],  1
       mov  r11,  1
       jmp  label275
label275:
       mov  rdi,  qword[C]
       mov  rbx,  rdi
       sub  rbx,  2
       cmp  r11,  rbx
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
       mov  r15,  qword[ksm]
       mov  rbx,  r15
       mov  r8,  r10
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r12,  r9
       mov  r13,  r11
       sub  r13,  1
       mov  rcx,  qword[ksm]
       mov  rbx,  rcx
       mov  rdi,  r10
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  r13
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       imul  rbx,  r10
       mov  rbx,  rbx
       mov  rcx,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  rcx
       mov  rbx,  rdx
       mov  rdi,  r11
       add  rdi,  1
       mov  qword [r12 + rdi * 8],  rbx
       jmp  label276
label276:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label275
label274:
       jmp  label269
label269:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
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
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       call  Calculate_Ksm
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       call  Calculate_p
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       call  Calculate_q
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       mov  r11,  1
       jmp  label282
label282:
       mov  r15,  qword[M]
       cmp  r11,  r15
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
       mov  qword [rbp-8],  2
       jmp  label289
label289:
       mov  r8,  qword [rbp-8]
       mov  r9,  qword[C]
       cmp  r8,  r9
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
       mov  r10,  0
       jmp  label296
label296:
       mov  rcx,  qword [rbp-8]
       mov  rbx,  rcx
       sub  rbx,  2
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
       mov  rdi,  qword[g]
       mov  rbx,  rdi
       mov  r15,  qword [rbx + 8]
       mov  rbx,  r15
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r12,  r9
       mov  rcx,  qword[g]
       mov  rbx,  rcx
       mov  rdi,  qword [rbx + 8]
       mov  rbx,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  r14,  r8
       mov  r9,  qword [rbp-8]
       mov  r13,  r9
       sub  r13,  2
       mov  rcx,  qword[p]
       mov  rbx,  rcx
       mov  rdi,  r13
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  qword[q]
       mov  r13,  r8
       mov  r9,  r10
       add  r9,  1
       mov  rcx,  qword [r13 + r9 * 8]
       mov  r13,  rcx
       mov  rdi,  r10
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [r13 + r8 * 8]
       imul  rbx,  r9
       mov  rcx,  qword [rbp-8]
       mov  rdi,  rcx
       add  rdi,  1
       mov  r15,  qword [r14 + rdi * 8]
       mov  r13,  r15
       add  r13,  rbx
       mov  rbx,  r13
       mov  r8,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r8
       mov  rbx,  rdx
       mov  r9,  qword [rbp-8]
       mov  rcx,  r9
       add  rcx,  1
       mov  qword [r12 + rcx * 8],  rbx
       jmp  label297
label297:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
       jmp  label296
label295:
       mov  r10,  1
       jmp  label303
label303:
       mov  rdi,  qword[N]
       cmp  r10,  rdi
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
       mov  r15,  qword[g]
       mov  rbx,  r15
       mov  r8,  r10
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  r11
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  r12,  rdi
       mov  r13,  r10
       sub  r13,  1
       mov  r15,  qword[g]
       mov  rbx,  r15
       mov  r8,  r13
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  r11
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  rbx,  rdi
       mov  r15,  qword [rbp-8]
       mov  r8,  r15
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       imul  rbx,  r11
       mov  rbx,  rbx
       mov  rcx,  qword[Mod]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  rcx
       mov  rbx,  rdx
       mov  rdi,  qword [rbp-8]
       mov  r15,  rdi
       add  r15,  1
       mov  qword [r12 + r15 * 8],  rbx
       jmp  label304
label304:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
       jmp  label303
label302:
       jmp  label290
label290:
       mov  r8,  qword [rbp-8]
       mov  rbx,  r8
       mov  r9,  rbx
       add  r9,  1
       mov  qword [rbp-8],  r9
       jmp  label289
label288:
       jmp  label283
label283:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label282
label281:
       mov  r10,  0
       jmp  label310
label310:
       mov  rcx,  qword[N]
       cmp  r10,  rcx
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
       mov  r11,  2
       jmp  label317
label317:
       mov  rdi,  qword[C]
       cmp  r11,  rdi
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
       mov  qword [rbp-8],  1
       jmp  label324
label324:
       mov  r15,  qword [rbp-8]
       mov  r8,  qword[M]
       cmp  r15,  r8
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
       mov  r9,  qword[Sum]
       mov  rbx,  r9
       mov  rcx,  r10
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  rbx,  rdi
       mov  r15,  qword [rbp-8]
       mov  r8,  r15
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r13,  r9
       mov  rcx,  qword [rbp-8]
       mov  rbx,  rcx
       sub  rbx,  1
       mov  rdi,  qword[Sum]
       mov  r12,  rdi
       mov  r15,  r10
       add  r15,  1
       mov  r8,  qword [r12 + r15 * 8]
       mov  r12,  r8
       mov  r9,  rbx
       add  r9,  1
       mov  rcx,  qword [r12 + r9 * 8]
       mov  rbx,  rcx
       mov  rdi,  qword[g]
       mov  r12,  rdi
       mov  r15,  r10
       add  r15,  1
       mov  r8,  qword [r12 + r15 * 8]
       mov  r12,  r8
       mov  r9,  qword [rbp-8]
       mov  rcx,  r9
       add  rcx,  1
       mov  rdi,  qword [r12 + rcx * 8]
       mov  r12,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  r9,  r11
       add  r9,  1
       mov  rcx,  qword [r12 + r9 * 8]
       add  rbx,  rcx
       mov  rdi,  r11
       add  rdi,  1
       mov  qword [r13 + rdi * 8],  rbx
       mov  r15,  qword[Sum]
       mov  rbx,  r15
       mov  r8,  r10
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  qword [rbp-8]
       mov  rdi,  rcx
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rcx,  qword[Mod]
       cmp  r9,  rcx
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
       mov  rdi,  qword[Sum]
       mov  rbx,  rdi
       mov  r15,  r10
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  r9,  qword [rbp-8]
       mov  rcx,  r9
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  r12,  rdi
       mov  r15,  qword[Sum]
       mov  rbx,  r15
       mov  r8,  r10
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  qword [rbp-8]
       mov  rdi,  rcx
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  qword[Mod]
       sub  rbx,  rcx
       mov  rdi,  r11
       add  rdi,  1
       mov  qword [r12 + rdi * 8],  rbx
       jmp  label331
label330:
       jmp  label331
label331:
       jmp  label325
label325:
       mov  r15,  qword [rbp-8]
       mov  rbx,  r15
       mov  r8,  rbx
       add  r8,  1
       mov  qword [rbp-8],  r8
       jmp  label324
label323:
       jmp  label318
label318:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label317
label316:
       jmp  label311
label311:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
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
       mov  r10,  0
       jmp  label337
label337:
       mov  r9,  qword[M]
       cmp  r10,  r9
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
       mov  rcx,  qword[Comb]
       mov  rbx,  rcx
       mov  rdi,  r10
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  qword [rbx + 8],  1
       jmp  label338
label338:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
       jmp  label337
label336:
       mov  r10,  1
       jmp  label344
label344:
       mov  r8,  qword[M]
       cmp  r10,  r8
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
       mov  r11,  1
       jmp  label351
label351:
       mov  r9,  qword[C]
       cmp  r11,  r9
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
       mov  rcx,  qword[Comb]
       mov  rbx,  rcx
       mov  rdi,  r10
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  r12,  r15
       mov  r13,  r10
       sub  r13,  1
       mov  r8,  qword[Comb]
       mov  rbx,  r8
       mov  r9,  r13
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  r13,  rcx
       mov  rbx,  r11
       sub  rbx,  1
       mov  qword [rbp-8],  r10
       mov  rdi,  qword [rbp-8]
       mov  r15,  rdi
       sub  r15,  1
       mov  qword [rbp-8],  r15
       mov  r8,  qword[Comb]
       mov  r14,  r8
       mov  r9,  qword [rbp-8]
       mov  rcx,  r9
       add  rcx,  1
       mov  rdi,  qword [r14 + rcx * 8]
       mov  r14,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  r8,  qword [r13 + r15 * 8]
       mov  r13,  r8
       mov  r9,  rbx
       add  r9,  1
       mov  rcx,  qword [r14 + r9 * 8]
       add  r13,  rcx
       mov  rdi,  r11
       add  rdi,  1
       mov  qword [r12 + rdi * 8],  r13
       mov  r15,  qword[Comb]
       mov  rbx,  r15
       mov  r8,  r10
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rbx,  r9
       mov  rcx,  r11
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  r15,  qword[Mod]
       cmp  rdi,  r15
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
       mov  r8,  qword[Comb]
       mov  rbx,  r8
       mov  r9,  r10
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  r12,  rcx
       mov  rdi,  qword[Comb]
       mov  rbx,  rdi
       mov  r15,  r10
       add  r15,  1
       mov  r8,  qword [rbx + r15 * 8]
       mov  rbx,  r8
       mov  r9,  r11
       add  r9,  1
       mov  rcx,  qword [rbx + r9 * 8]
       mov  rbx,  rcx
       mov  rdi,  qword[Mod]
       sub  rbx,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  qword [r12 + r15 * 8],  rbx
       jmp  label358
label357:
       jmp  label358
label358:
       jmp  label352
label352:
       mov  rbx,  r11
       mov  r11,  rbx
       add  r11,  1
       jmp  label351
label350:
       jmp  label345
label345:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
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
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       call  getInt
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       mov  qword [rbp-8],  rbx
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       call  init
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       mov  r8,  qword[fn]
       mov  rbx,  r8
       mov  qword [rbx + 16],  2
       mov  r9,  qword[fc]
       mov  rbx,  r9
       mov  qword [rbx + 16],  3
       mov  rcx,  qword[fm]
       mov  rbx,  rcx
       mov  rdi,  qword [rbx + 16]
       mov  rbx,  rdi
       mov  qword [rbx + 16],  3
       mov  r15,  qword[fm]
       mov  rbx,  r15
       mov  r8,  qword [rbx + 16]
       mov  rbx,  r8
       mov  qword [rbx + 24],  4
       mov  r9,  qword[fn]
       mov  rbx,  r9
       mov  qword [rbx + 24],  3
       mov  rcx,  qword[fc]
       mov  rbx,  rcx
       mov  qword [rbx + 24],  3
       mov  rdi,  qword[fm]
       mov  rbx,  rdi
       mov  r15,  qword [rbx + 24]
       mov  rbx,  r15
       mov  qword [rbx + 16],  3
       mov  r8,  qword[fm]
       mov  rbx,  r8
       mov  r9,  qword [rbx + 24]
       mov  rbx,  r9
       mov  qword [rbx + 24],  4
       mov  rcx,  qword[fm]
       mov  rbx,  rcx
       mov  rdi,  qword [rbx + 24]
       mov  rbx,  rdi
       mov  qword [rbx + 32],  4
       mov  r15,  qword[fn]
       mov  rbx,  r15
       mov  qword [rbx + 32],  4
       mov  r8,  qword[fc]
       mov  rbx,  r8
       mov  qword [rbx + 32],  4
       mov  r9,  qword[fm]
       mov  rbx,  r9
       mov  rcx,  qword [rbx + 32]
       mov  rbx,  rcx
       mov  qword [rbx + 16],  5
       mov  rdi,  qword[fm]
       mov  rbx,  rdi
       mov  r15,  qword [rbx + 32]
       mov  rbx,  r15
       mov  qword [rbx + 24],  7
       mov  r8,  qword[fm]
       mov  rbx,  r8
       mov  r9,  qword [rbx + 32]
       mov  rbx,  r9
       mov  qword [rbx + 32],  8
       mov  rcx,  qword[fm]
       mov  rbx,  rcx
       mov  rdi,  qword [rbx + 32]
       mov  rbx,  rdi
       mov  qword [rbx + 40],  9
       mov  qword[C],  4
       mov  qword[M],  9
       mov  qword[N],  4
       mov  qword[Mod],  10007
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       call  Calculate_G
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       call  Calculate_Comb
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       mov  qword [rbp-16],  1
       jmp  label364
label364:
       mov  r15,  qword [rbp-16]
       mov  r8,  qword [rbp-8]
       cmp  r15,  r8
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
       mov  r9,  qword[fn]
       mov  rbx,  r9
       mov  rcx,  qword [rbp-16]
       mov  rdi,  rcx
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  qword [rbp-24],  r15
       mov  r8,  qword[fc]
       mov  rbx,  r8
       mov  r9,  qword [rbp-16]
       mov  rcx,  r9
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  r13,  rdi
       mov  r10,  1
       jmp  label371
label371:
       mov  r15,  qword [rbp-24]
       cmp  r10,  r15
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
       mov  r8,  qword[m]
       mov  r11,  r8
       mov  r9,  qword[fm]
       mov  rbx,  r9
       mov  rcx,  qword [rbp-16]
       mov  rdi,  rcx
       add  rdi,  1
       mov  r15,  qword [rbx + rdi * 8]
       mov  rbx,  r15
       mov  r8,  r10
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rcx,  r10
       add  rcx,  1
       mov  qword [r11 + rcx * 8],  r9
       jmp  label372
label372:
       mov  rbx,  r10
       mov  r10,  rbx
       add  r10,  1
       jmp  label371
label370:
       mov  rdi,  qword [rbp-24]
       cmp  rdi,  1
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
       mov  r15,  qword[m]
       mov  r10,  r15
       mov  r8,  qword[Comb]
       mov  rbx,  r8
       mov  r9,  qword [r10 + 16]
       mov  rcx,  r9
       add  rcx,  1
       mov  rdi,  qword [rbx + rcx * 8]
       mov  rbx,  rdi
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       mov  r15,  r13
       add  r15,  1
       mov  rdi,  qword [rbx + r15 * 8]
       call  toString
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       mov  rdi,  rbx
       call  println
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       jmp  label378
label377:
       mov  qword [rbp-32],  0
       mov  rbx,  0
       mov  r11,  0
       mov  rbx,  1
       jmp  label384
label384:
       mov  r8,  qword[m]
       mov  r10,  r8
       mov  r9,  qword [r10 + 16]
       cmp  rbx,  r9
       jg  label387
label386:
       mov  r10,  1
       jmp  label388
label387:
       mov  r10,  0
       jmp  label388
label388:
       cmp  r10,  0
       jz  label383
label382:
       mov  rcx,  qword[m]
       mov  r12,  rcx
       mov  rdi,  qword[m]
       mov  r10,  rdi
       mov  r15,  qword [r10 + 16]
       mov  r10,  r15
       mov  rax,  r10
       mov  rdx,  0
       idiv  rbx
       mov  r10,  rax
       mov  r8,  qword [r12 + 16]
       mov  r12,  r8
       mov  rax,  r12
       mov  rdx,  0
       idiv  r10
       mov  r12,  rax
       mov  qword [rbp-40],  r12
       mov  r12,  2
       jmp  label391
label391:
       mov  r9,  qword [rbp-24]
       cmp  r12,  r9
       jg  label394
label393:
       mov  r10,  1
       jmp  label395
label394:
       mov  r10,  0
       jmp  label395
label395:
       cmp  r10,  0
       jz  label390
label389:
       mov  rcx,  qword[m]
       mov  r14,  rcx
       mov  rdi,  qword[m]
       mov  r10,  rdi
       mov  r15,  r12
       add  r15,  1
       mov  r8,  qword [r10 + r15 * 8]
       mov  r10,  r8
       mov  rax,  r10
       mov  rdx,  0
       idiv  rbx
       mov  r10,  rax
       mov  r9,  r12
       add  r9,  1
       mov  rcx,  qword [r14 + r9 * 8]
       mov  r14,  rcx
       mov  rax,  r14
       mov  rdx,  0
       idiv  r10
       mov  r14,  rax
       mov  rdi,  qword [rbp-40]
       cmp  r14,  rdi
       jge  label400
label399:
       mov  r10,  1
       jmp  label401
label400:
       mov  r10,  0
       jmp  label401
label401:
       cmp  r10,  0
       jz  label397
label396:
       mov  qword [rbp-40],  r14
       jmp  label398
label397:
       jmp  label398
label398:
       jmp  label392
label392:
       mov  r10,  r12
       mov  r12,  r10
       add  r12,  1
       jmp  label391
label390:
       mov  r15,  qword[m]
       mov  rbx,  r15
       mov  r8,  qword [rbx + 16]
       mov  r9,  qword [rbp-40]
       cmp  r8,  r9
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
       mov  rcx,  qword[m]
       mov  rbx,  rcx
       mov  rdi,  qword [rbx + 16]
       mov  qword [rbp-40],  rdi
       jmp  label404
label403:
       jmp  label404
label404:
       mov  r15,  qword [rbp-40]
       mov  rbx,  r15
       mov  r8,  qword[b]
       mov  r10,  r8
       mov  qword [r10 + 8],  1
       mov  r12,  1
       jmp  label410
label410:
       mov  r9,  qword [rbp-24]
       cmp  r12,  r9
       jg  label413
label412:
       mov  r10,  1
       jmp  label414
label413:
       mov  r10,  0
       jmp  label414
label414:
       cmp  r10,  0
       jz  label409
label408:
       mov  rcx,  qword[m]
       mov  r10,  rcx
       mov  rdi,  r12
       add  rdi,  1
       mov  r15,  qword [r10 + rdi * 8]
       mov  r10,  r15
       mov  rax,  r10
       mov  rdx,  0
       idiv  rbx
       mov  r10,  rax
       mov  r8,  qword[Mod]
       mov  rax,  r10
       mov  rdx,  0
       idiv  r8
       mov  r10,  rdx
       mov  qword [rbp-48],  r10
       mov  r9,  qword [rbp-48]
       mov  rcx,  r9
       add  rcx,  1
       mov  qword [rbp-48],  rcx
       mov  r14,  r10
       mov  rdi,  qword [rbp-48]
       imul  r14,  rdi
       mov  r14,  r14
       mov  rax,  r14
       mov  r15,  2
       mov  rdx,  0
       idiv  r15
       mov  r14,  rax
       mov  r8,  qword[Mod]
       mov  rax,  r14
       mov  rdx,  0
       idiv  r8
       mov  r14,  rdx
       mov  qword [rbp-56],  r14
       mov  r9,  qword[m]
       mov  r14,  r9
       mov  rcx,  r12
       add  rcx,  1
       mov  rdi,  qword [r14 + rcx * 8]
       mov  r14,  rdi
       imul  r14,  r10
       mov  r10,  r14
       mov  r15,  qword[Mod]
       mov  rax,  r10
       mov  rdx,  0
       idiv  r15
       mov  r10,  rdx
       mov  qword [rbp-64],  r10
       mov  qword [rbp-72],  0
       jmp  label417
label417:
       mov  r8,  qword [rbp-72]
       cmp  r8,  r12
       jge  label420
label419:
       mov  r10,  1
       jmp  label421
label420:
       mov  r10,  0
       jmp  label421
label421:
       cmp  r10,  0
       jz  label416
label415:
       mov  r9,  qword [rbp-72]
       mov  r14,  r9
       add  r14,  1
       mov  rcx,  qword[res]
       mov  qword [rbp-80],  rcx
       mov  rdi,  qword[b]
       mov  r10,  rdi
       mov  r15,  qword[Mod]
       mov  qword [rbp-88],  r15
       mov  r8,  qword [rbp-88]
       mov  r9,  qword [rbp-56]
       mov  rcx,  r8
       sub  rcx,  r9
       mov  qword [rbp-88],  rcx
       mov  rdi,  qword [rbp-72]
       mov  r15,  rdi
       add  r15,  1
       mov  r8,  qword [r10 + r15 * 8]
       mov  r10,  r8
       mov  r9,  qword [rbp-88]
       imul  r10,  r9
       mov  r10,  r10
       mov  rcx,  qword[Mod]
       mov  rax,  r10
       mov  rdx,  0
       idiv  rcx
       mov  r10,  rdx
       mov  rdi,  qword [rbp-80]
       mov  r15,  r14
       add  r15,  1
       mov  qword [rdi + r15 * 8],  r10
       jmp  label418
label418:
       mov  r8,  qword [rbp-72]
       mov  r10,  r8
       mov  r9,  r10
       add  r9,  1
       mov  qword [rbp-72],  r9
       jmp  label417
label416:
       mov  rcx,  qword[res]
       mov  r10,  rcx
       mov  qword [r10 + 8],  0
       mov  qword [rbp-72],  0
       jmp  label424
label424:
       mov  rdi,  qword [rbp-72]
       cmp  rdi,  r12
       jge  label427
label426:
       mov  r10,  1
       jmp  label428
label427:
       mov  r10,  0
       jmp  label428
label428:
       cmp  r10,  0
       jz  label423
label422:
       mov  r15,  qword[res]
       mov  r14,  r15
       mov  r8,  qword[res]
       mov  qword [rbp-96],  r8
       mov  r9,  qword[b]
       mov  qword [rbp-104],  r9
       mov  rcx,  qword [rbp-64]
       mov  r10,  rcx
       mov  rdi,  qword [rbp-104]
       mov  r15,  qword [rbp-72]
       mov  r8,  r15
       add  r8,  1
       mov  r9,  qword [rdi + r8 * 8]
       imul  r10,  r9
       mov  rcx,  qword [rbp-96]
       mov  rdi,  qword [rbp-72]
       mov  r15,  rdi
       add  r15,  1
       mov  r8,  qword [rcx + r15 * 8]
       mov  qword [rbp-112],  r8
       mov  r9,  qword [rbp-112]
       mov  rcx,  r9
       add  rcx,  r10
       mov  qword [rbp-112],  rcx
       mov  rdi,  qword [rbp-112]
       mov  r10,  rdi
       mov  r15,  qword[Mod]
       mov  rax,  r10
       mov  rdx,  0
       idiv  r15
       mov  r10,  rdx
       mov  r8,  qword [rbp-72]
       mov  r9,  r8
       add  r9,  1
       mov  qword [r14 + r9 * 8],  r10
       jmp  label425
label425:
       mov  rcx,  qword [rbp-72]
       mov  r10,  rcx
       mov  rdi,  r10
       add  rdi,  1
       mov  qword [rbp-72],  rdi
       jmp  label424
label423:
       mov  qword [rbp-72],  0
       jmp  label431
label431:
       mov  r15,  qword [rbp-72]
       cmp  r15,  r12
       jg  label434
label433:
       mov  r10,  1
       jmp  label435
label434:
       mov  r10,  0
       jmp  label435
label435:
       cmp  r10,  0
       jz  label430
label429:
       mov  r8,  qword[b]
       mov  r14,  r8
       mov  r9,  qword[res]
       mov  r10,  r9
       mov  rcx,  qword [rbp-72]
       mov  rdi,  rcx
       add  rdi,  1
       mov  r15,  qword [r10 + rdi * 8]
       mov  r8,  qword [rbp-72]
       mov  r9,  r8
       add  r9,  1
       mov  qword [r14 + r9 * 8],  r15
       jmp  label432
label432:
       mov  rcx,  qword [rbp-72]
       mov  r10,  rcx
       mov  rdi,  r10
       add  rdi,  1
       mov  qword [rbp-72],  rdi
       jmp  label431
label430:
       jmp  label411
label411:
       mov  r10,  r12
       mov  r12,  r10
       add  r12,  1
       jmp  label410
label409:
       mov  r12,  0
       jmp  label438
label438:
       mov  r15,  qword [rbp-24]
       cmp  r12,  r15
       jg  label441
label440:
       mov  r10,  1
       jmp  label442
label441:
       mov  r10,  0
       jmp  label442
label442:
       cmp  r10,  0
       jz  label437
label436:
       mov  r8,  qword[b]
       mov  r14,  r8
       mov  r9,  qword[Sum]
       mov  r10,  r9
       mov  rcx,  r12
       add  rcx,  1
       mov  rdi,  qword [r10 + rcx * 8]
       mov  r10,  rdi
       mov  r15,  rbx
       add  r15,  1
       mov  r8,  qword [r10 + r15 * 8]
       mov  qword [rbp-120],  r8
       mov  r9,  qword[Sum]
       mov  r10,  r9
       mov  rcx,  r12
       add  rcx,  1
       mov  rdi,  qword [r10 + rcx * 8]
       mov  r10,  rdi
       mov  r15,  r11
       add  r15,  1
       mov  r8,  qword [r10 + r15 * 8]
       mov  r10,  r8
       mov  r9,  qword [rbp-120]
       mov  rcx,  r13
       add  rcx,  1
       mov  rdi,  qword [r9 + rcx * 8]
       mov  qword [rbp-128],  rdi
       mov  r15,  qword [rbp-128]
       mov  r8,  r13
       add  r8,  1
       mov  r9,  qword [r10 + r8 * 8]
       mov  rcx,  r15
       sub  rcx,  r9
       mov  qword [rbp-128],  rcx
       mov  rdi,  r12
       add  rdi,  1
       mov  r15,  qword [r14 + rdi * 8]
       mov  r10,  r15
       mov  r8,  qword [rbp-128]
       imul  r10,  r8
       mov  r9,  qword [rbp-32]
       mov  r14,  r9
       add  r14,  r10
       mov  r10,  r14
       mov  rcx,  qword[Mod]
       mov  rax,  r10
       mov  rdx,  0
       idiv  rcx
       mov  r10,  rdx
       mov  qword [rbp-32],  r10
       jmp  label439
label439:
       mov  r10,  r12
       mov  r12,  r10
       add  r12,  1
       jmp  label438
label437:
       mov  r11,  rbx
       jmp  label385
label385:
       mov  rbx,  rbx
       add  rbx,  1
       jmp  label384
label383:
       mov  rdi,  qword [rbp-32]
       cmp  rdi,  0
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
       mov  r15,  qword [rbp-32]
       mov  rbx,  r15
       mov  r8,  qword[Mod]
       add  rbx,  r8
       mov  qword [rbp-32],  rbx
       jmp  label445
label444:
       jmp  label445
label445:
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       mov  rdi,  qword [rbp-32]
       call  toString
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       mov  rbx,  rax
       push  rbp
       push  rbx
       push  r13
       push  r14
       push  r10
       push  r11
       push  r12
       mov  rdi,  rbx
       call  println
       pop  r12
       pop  r11
       pop  r10
       pop  r14
       pop  r13
       pop  rbx
       pop  rbp
       jmp  label378
label378:
       jmp  label365
label365:
       mov  r9,  qword [rbp-16]
       mov  rbx,  r9
       mov  rcx,  rbx
       add  rcx,  1
       mov  qword [rbp-16],  rcx
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
