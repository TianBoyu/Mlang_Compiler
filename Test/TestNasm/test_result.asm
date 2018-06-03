global    array_equal
global    int2chr
global    MAXLENGTH
global    lohi
global    nextLetter
global    MAXCHUNK
global    toStringHex
global    rotate_left
global    sha1
global    hex2int
global    computeSHA1
global    inputBuffer
global    main
global    asciiTable
global    nextText
global    add
global    chunks
global    crackSHA1
global    outputBuffer


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

hex2int:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  240
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-24],  0
       mov  qword [rbp-16],  0
label2:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  length
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-32]
       cmp  rcx,  rdx
       jge  label5
label4:
       mov  qword [rbp-40],  1
       jmp  label6
label5:
       mov  qword [rbp-40],  0
label6:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label1
label0:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       call  ord
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  qword [rbp-48],  rax
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  48
       jl  label16
label15:
       mov  qword [rbp-64],  1
       jmp  label17
label16:
       mov  qword [rbp-64],  0
label17:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label13
label10:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  57
       jg  label19
label18:
       mov  qword [rbp-72],  1
       jmp  label20
label19:
       mov  qword [rbp-72],  0
label20:
       mov  rcx,  qword [rbp-72]
       cmp  rcx,  0
       jz  label13
label12:
       mov  qword [rbp-80],  1
       jmp  label14
label13:
       mov  qword [rbp-80],  0
label14:
       mov  rcx,  qword [rbp-80]
       cmp  rcx,  0
       jz  label8
label7:
       mov  rax,  qword [rbp-24]
       imul  rax,  16
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  rdx,  qword [rbp-48]
       add  rax,  rdx
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       sub  rax,  48
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  qword [rbp-24],  rax
       jmp  label9
label8:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  65
       jl  label30
label29:
       mov  qword [rbp-112],  1
       jmp  label31
label30:
       mov  qword [rbp-112],  0
label31:
       mov  rcx,  qword [rbp-112]
       cmp  rcx,  0
       jz  label27
label24:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  70
       jg  label33
label32:
       mov  qword [rbp-120],  1
       jmp  label34
label33:
       mov  qword [rbp-120],  0
label34:
       mov  rcx,  qword [rbp-120]
       cmp  rcx,  0
       jz  label27
label26:
       mov  qword [rbp-128],  1
       jmp  label28
label27:
       mov  qword [rbp-128],  0
label28:
       mov  rcx,  qword [rbp-128]
       cmp  rcx,  0
       jz  label22
label21:
       mov  rax,  qword [rbp-24]
       imul  rax,  16
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  rdx,  qword [rbp-48]
       add  rax,  rdx
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-144]
       sub  rax,  65
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       add  rax,  10
       mov  qword [rbp-160],  rax
       mov  rax,  qword [rbp-160]
       mov  qword [rbp-24],  rax
       jmp  label23
label22:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  97
       jl  label44
label43:
       mov  qword [rbp-168],  1
       jmp  label45
label44:
       mov  qword [rbp-168],  0
label45:
       mov  rcx,  qword [rbp-168]
       cmp  rcx,  0
       jz  label41
label38:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  102
       jg  label47
label46:
       mov  qword [rbp-176],  1
       jmp  label48
label47:
       mov  qword [rbp-176],  0
label48:
       mov  rcx,  qword [rbp-176]
       cmp  rcx,  0
       jz  label41
label40:
       mov  qword [rbp-184],  1
       jmp  label42
label41:
       mov  qword [rbp-184],  0
label42:
       mov  rcx,  qword [rbp-184]
       cmp  rcx,  0
       jz  label36
label35:
       mov  rax,  qword [rbp-24]
       imul  rax,  16
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-192]
       mov  rdx,  qword [rbp-48]
       add  rax,  rdx
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-200]
       sub  rax,  97
       mov  qword [rbp-208],  rax
       mov  rax,  qword [rbp-208]
       add  rax,  10
       mov  qword [rbp-216],  rax
       mov  rax,  qword [rbp-216]
       mov  qword [rbp-24],  rax
       jmp  label37
label36:
       mov  rax,  0
       add  rsp,  240
       pop  rbp
       ret  
       jmp  label37
label37:
       jmp  label23
label23:
       jmp  label9
label9:
label3:
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-224],  rax
       mov  rax,  qword [rbp-16]
       add  rax,  1
       mov  qword [rbp-16],  rax
       jmp  label2
label1:
       mov  rax,  qword [rbp-24]
       add  rsp,  240
       pop  rbp
       ret  
       add  rsp,  240
       pop  rbp
       ret  
int2chr:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  qword [rbp-8],  rdi
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  32
       jl  label58
label57:
       mov  qword [rbp-16],  1
       jmp  label59
label58:
       mov  qword [rbp-16],  0
label59:
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jz  label55
label52:
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  126
       jg  label61
label60:
       mov  qword [rbp-24],  1
       jmp  label62
label61:
       mov  qword [rbp-24],  0
label62:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label55
label54:
       mov  qword [rbp-32],  1
       jmp  label56
label55:
       mov  qword [rbp-32],  0
label56:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label50
label49:
       mov  rax,  qword [rbp-8]
       sub  rax,  32
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-8]
       sub  rax,  32
       mov  qword [rbp-56],  rax
       mov  rax,  qword[asciiTable]
       mov  rdi,  rax
       mov  rax,  qword [rbp-48]
       mov  rsi,  rax
       mov  rax,  qword [rbp-56]
       mov  rdx,  rax
       call  substring
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       add  rsp,  80
       pop  rbp
       ret  
       jmp  label51
label50:
       jmp  label51
label51:
       mov  rax,  String_1
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
toStringHex:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  144
       mov  qword [rbp-8],  rdi
       mov  rax,  String_2
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rbp-16],  rax
       mov  qword [rbp-32],  28
label65:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jl  label68
label67:
       mov  qword [rbp-40],  1
       jmp  label69
label68:
       mov  qword [rbp-40],  0
label69:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label64
label63:
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-32]
       mov  rcx,  rdx
       shr  rax,  cl
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       and  rax,  15
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  qword [rbp-48],  rax
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  10
       jge  label74
label73:
       mov  qword [rbp-72],  1
       jmp  label75
label74:
       mov  qword [rbp-72],  0
label75:
       mov  rcx,  qword [rbp-72]
       cmp  rcx,  0
       jz  label71
label70:
       mov  rax,  48
       mov  rcx,  qword [rbp-48]
       add  rax,  rcx
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       mov  rdi,  rax
       call  int2chr
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       mov  rax,  qword [rbp-88]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  qword [rbp-16],  rax
       jmp  label72
label71:
       mov  rax,  65
       mov  rcx,  qword [rbp-48]
       add  rax,  rcx
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       sub  rax,  10
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-128]
       mov  rdi,  rax
       call  int2chr
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       mov  rax,  qword [rbp-112]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  qword [rbp-16],  rax
       jmp  label72
label72:
label66:
       mov  rax,  qword [rbp-32]
       sub  rax,  4
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  qword [rbp-32],  rax
       jmp  label65
label64:
       mov  rax,  qword [rbp-16]
       add  rsp,  144
       pop  rbp
       ret  
       add  rsp,  144
       pop  rbp
       ret  
rotate_left:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  224
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  1
       jne  label80
label79:
       mov  qword [rbp-24],  1
       jmp  label81
label80:
       mov  qword [rbp-24],  0
label81:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label77
label76:
       mov  rax,  qword [rbp-8]
       and  rax,  2147483647
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  rcx,  1
       shl  rax,  cl
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-8]
       mov  rcx,  31
       shr  rax,  cl
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       and  rax,  1
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-40]
       mov  rdx,  qword [rbp-56]
       or  rax,  rdx
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       add  rsp,  224
       pop  rbp
       ret  
       jmp  label78
label77:
       jmp  label78
label78:
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  31
       jne  label86
label85:
       mov  qword [rbp-72],  1
       jmp  label87
label86:
       mov  qword [rbp-72],  0
label87:
       mov  rcx,  qword [rbp-72]
       cmp  rcx,  0
       jz  label83
label82:
       mov  rax,  qword [rbp-8]
       and  rax,  1
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  rcx,  31
       shl  rax,  cl
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-8]
       mov  rcx,  1
       shr  rax,  cl
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       and  rax,  2147483647
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-88]
       mov  rdx,  qword [rbp-104]
       or  rax,  rdx
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       add  rsp,  224
       pop  rbp
       ret  
       jmp  label84
label83:
       jmp  label84
label84:
       mov  rax,  32
       mov  rcx,  qword [rbp-16]
       sub  rax,  rcx
       mov  qword [rbp-120],  rax
       mov  rax,  1
       mov  rcx,  qword [rbp-120]
       shl  rax,  cl
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-128]
       sub  rax,  1
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-136]
       and  rax,  rdx
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-144]
       mov  rdx,  qword [rbp-16]
       mov  rcx,  rdx
       shl  rax,  cl
       mov  qword [rbp-152],  rax
       mov  rax,  32
       mov  rcx,  qword [rbp-16]
       sub  rax,  rcx
       mov  qword [rbp-160],  rax
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-160]
       mov  rcx,  rdx
       shr  rax,  cl
       mov  qword [rbp-168],  rax
       mov  rax,  1
       mov  rcx,  qword [rbp-16]
       shl  rax,  cl
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-176]
       sub  rax,  1
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-168]
       mov  rdx,  qword [rbp-184]
       and  rax,  rdx
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-152]
       mov  rdx,  qword [rbp-192]
       or  rax,  rdx
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-200]
       add  rsp,  224
       pop  rbp
       ret  
       add  rsp,  224
       pop  rbp
       ret  
add:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  160
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-8]
       and  rax,  65535
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-16]
       and  rax,  65535
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-32]
       mov  rdx,  qword [rbp-40]
       add  rax,  rdx
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-8]
       mov  rcx,  16
       shr  rax,  cl
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       and  rax,  65535
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-16]
       mov  rcx,  16
       shr  rax,  cl
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       and  rax,  65535
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-72]
       mov  rdx,  qword [rbp-88]
       add  rax,  rdx
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-24]
       mov  rcx,  16
       shr  rax,  cl
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-96]
       mov  rdx,  qword [rbp-104]
       add  rax,  rdx
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       and  rax,  65535
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  rcx,  16
       shl  rax,  cl
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-24]
       and  rax,  65535
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-128]
       mov  rdx,  qword [rbp-136]
       or  rax,  rdx
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-144]
       add  rsp,  160
       pop  rbp
       ret  
       add  rsp,  160
       pop  rbp
       ret  
lohi:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  48
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-16]
       mov  rcx,  16
       shl  rax,  cl
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-24]
       or  rax,  rdx
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       add  rsp,  48
       pop  rbp
       ret  
       add  rsp,  48
       pop  rbp
       ret  
sha1:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  832
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-16]
       add  rax,  64
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       sub  rax,  56
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       add  rax,  1
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  qword [rbp-24],  rax
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[MAXCHUNK]
       cmp  rcx,  rdx
       jle  label96
label95:
       mov  qword [rbp-64],  1
       jmp  label97
label96:
       mov  qword [rbp-64],  0
label97:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label93
label92:
       mov  rax,  String_3
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-72]
       mov  rdi,  rax
       call  println
       add  rsp,  832
       pop  rbp
       ret  
       jmp  label94
label93:
       jmp  label94
label94:
       mov  qword [rbp-80],  0
label100:
       mov  rcx,  qword [rbp-80]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       jge  label103
label102:
       mov  qword [rbp-96],  1
       jmp  label104
label103:
       mov  qword [rbp-96],  0
label104:
       mov  rcx,  qword [rbp-96]
       cmp  rcx,  0
       jz  label99
label98:
       mov  qword [rbp-88],  0
label107:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  80
       jge  label110
label109:
       mov  qword [rbp-104],  1
       jmp  label111
label110:
       mov  qword [rbp-104],  0
label111:
       mov  rcx,  qword [rbp-104]
       cmp  rcx,  0
       jz  label106
label105:
       mov  rdx,  qword[chunks]
       mov  rbx,  qword [rbp-80]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-88]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  0
label108:
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-88]
       add  rax,  1
       mov  qword [rbp-88],  rax
       jmp  label107
label106:
label101:
       mov  rax,  qword [rbp-80]
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-80]
       add  rax,  1
       mov  qword [rbp-80],  rax
       jmp  label100
label99:
       mov  qword [rbp-80],  0
label114:
       mov  rcx,  qword [rbp-80]
       mov  rdx,  qword [rbp-16]
       cmp  rcx,  rdx
       jge  label117
label116:
       mov  qword [rbp-128],  1
       jmp  label118
label117:
       mov  qword [rbp-128],  0
label118:
       mov  rcx,  qword [rbp-128]
       cmp  rcx,  0
       jz  label113
label112:
       mov  rax,  qword [rbp-80]
       mov  rdx,  rax
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-136],  rdx
       mov  rax,  qword [rbp-136]
       mov  rcx,  4
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-80]
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-80]
       mov  rdx,  rax
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-160],  rdx
       mov  rax,  qword [rbp-160]
       mov  rcx,  4
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-80]
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-80]
       mov  rdx,  rax
       mov  rcx,  4
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-184],  rdx
       mov  rax,  3
       mov  rcx,  qword [rbp-184]
       sub  rax,  rcx
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-192]
       imul  rax,  8
       mov  qword [rbp-200],  rax
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-80]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword [rbp-200]
       mov  rcx,  r8
       shl  rax,  cl
       mov  qword [rbp-208],  rax
       mov  rbx,  qword[chunks]
       mov  r8,  qword [rbp-176]
       add  r8,  1
       mov  rcx,  qword [rbx + r8 * 8]
       mov  rdx,  qword [rbp-168]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r10,  qword [rbp-208]
       or  rax,  r10
       mov  qword [rbp-216],  rax
       mov  r8,  qword [rbp-216]
       mov  rdx,  qword[chunks]
       mov  rbx,  qword [rbp-152]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-144]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
label115:
       mov  rax,  qword [rbp-80]
       mov  qword [rbp-224],  rax
       mov  rax,  qword [rbp-80]
       add  rax,  1
       mov  qword [rbp-80],  rax
       jmp  label114
label113:
       mov  rax,  qword [rbp-80]
       mov  rdx,  rax
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-232],  rdx
       mov  rax,  qword [rbp-232]
       mov  rcx,  4
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-240],  rax
       mov  rax,  qword [rbp-80]
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-248],  rax
       mov  rax,  qword [rbp-80]
       mov  rdx,  rax
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-256],  rdx
       mov  rax,  qword [rbp-256]
       mov  rcx,  4
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-264],  rax
       mov  rax,  qword [rbp-80]
       mov  rcx,  64
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-80]
       mov  rdx,  rax
       mov  rcx,  4
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-280],  rdx
       mov  rax,  3
       mov  rcx,  qword [rbp-280]
       sub  rax,  rcx
       mov  qword [rbp-288],  rax
       mov  rax,  qword [rbp-288]
       imul  rax,  8
       mov  qword [rbp-296],  rax
       mov  rax,  128
       mov  rcx,  qword [rbp-296]
       shl  rax,  cl
       mov  qword [rbp-304],  rax
       mov  rbx,  qword[chunks]
       mov  r8,  qword [rbp-272]
       add  r8,  1
       mov  rcx,  qword [rbx + r8 * 8]
       mov  rdx,  qword [rbp-264]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r10,  qword [rbp-304]
       or  rax,  r10
       mov  qword [rbp-312],  rax
       mov  r8,  qword [rbp-312]
       mov  rdx,  qword[chunks]
       mov  rbx,  qword [rbp-248]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-240]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
       mov  rax,  qword [rbp-24]
       sub  rax,  1
       mov  qword [rbp-320],  rax
       mov  rax,  qword [rbp-16]
       mov  rcx,  3
       shl  rax,  cl
       mov  qword [rbp-328],  rax
       mov  rbx,  qword [rbp-328]
       mov  rcx,  qword[chunks]
       mov  rdx,  qword [rbp-320]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 128],  rbx
       mov  rax,  qword [rbp-24]
       sub  rax,  1
       mov  qword [rbp-336],  rax
       mov  rax,  qword [rbp-16]
       mov  rcx,  29
       shr  rax,  cl
       mov  qword [rbp-344],  rax
       mov  rax,  qword [rbp-344]
       and  rax,  7
       mov  qword [rbp-352],  rax
       mov  rbx,  qword [rbp-352]
       mov  rcx,  qword[chunks]
       mov  rdx,  qword [rbp-336]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 120],  rbx
       mov  qword [rbp-360],  1732584193
       mov  rdi,  43913
       mov  rsi,  61389
       call  lohi
       mov  qword [rbp-376],  rax
       mov  rax,  qword [rbp-376]
       mov  qword [rbp-368],  rax
       mov  rdi,  56574
       mov  rsi,  39098
       call  lohi
       mov  qword [rbp-392],  rax
       mov  rax,  qword [rbp-392]
       mov  qword [rbp-384],  rax
       mov  qword [rbp-400],  271733878
       mov  rdi,  57840
       mov  rsi,  50130
       call  lohi
       mov  qword [rbp-416],  rax
       mov  rax,  qword [rbp-416]
       mov  qword [rbp-408],  rax
       mov  qword [rbp-80],  0
label121:
       mov  rcx,  qword [rbp-80]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       jge  label124
label123:
       mov  qword [rbp-424],  1
       jmp  label125
label124:
       mov  qword [rbp-424],  0
label125:
       mov  rcx,  qword [rbp-424]
       cmp  rcx,  0
       jz  label120
label119:
       mov  qword [rbp-88],  16
label128:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  80
       jge  label131
label130:
       mov  qword [rbp-432],  1
       jmp  label132
label131:
       mov  qword [rbp-432],  0
label132:
       mov  rcx,  qword [rbp-432]
       cmp  rcx,  0
       jz  label127
label126:
       mov  rax,  qword [rbp-88]
       sub  rax,  3
       mov  qword [rbp-448],  rax
       mov  rax,  qword [rbp-88]
       sub  rax,  8
       mov  qword [rbp-456],  rax
       mov  rbx,  qword[chunks]
       mov  r8,  qword [rbp-80]
       add  r8,  1
       mov  rcx,  qword [rbx + r8 * 8]
       mov  rdx,  qword [rbp-448]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r12,  qword[chunks]
       mov  r13,  qword [rbp-80]
       add  r13,  1
       mov  r10,  qword [r12 + r13 * 8]
       mov  r11,  qword [rbp-456]
       add  r11,  1
       mov  r14,  qword [r10 + r11 * 8]
       xor  rax,  r14
       mov  qword [rbp-464],  rax
       mov  rax,  qword [rbp-88]
       sub  rax,  14
       mov  qword [rbp-472],  rax
       mov  rax,  qword [rbp-464]
       mov  r8,  qword[chunks]
       mov  r9,  qword [rbp-80]
       add  r9,  1
       mov  rdx,  qword [r8 + r9 * 8]
       mov  rbx,  qword [rbp-472]
       add  rbx,  1
       mov  r10,  qword [rdx + rbx * 8]
       xor  rax,  r10
       mov  qword [rbp-480],  rax
       mov  rax,  qword [rbp-88]
       sub  rax,  16
       mov  qword [rbp-488],  rax
       mov  rax,  qword [rbp-480]
       mov  r8,  qword[chunks]
       mov  r9,  qword [rbp-80]
       add  r9,  1
       mov  rdx,  qword [r8 + r9 * 8]
       mov  rbx,  qword [rbp-488]
       add  rbx,  1
       mov  r10,  qword [rdx + rbx * 8]
       xor  rax,  r10
       mov  qword [rbp-496],  rax
       mov  rax,  qword [rbp-496]
       mov  rdi,  rax
       mov  rsi,  1
       call  rotate_left
       mov  qword [rbp-440],  rax
       mov  r8,  qword [rbp-440]
       mov  rdx,  qword[chunks]
       mov  rbx,  qword [rbp-80]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-88]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
label129:
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-504],  rax
       mov  rax,  qword [rbp-88]
       add  rax,  1
       mov  qword [rbp-88],  rax
       jmp  label128
label127:
       mov  rax,  qword [rbp-360]
       mov  qword [rbp-512],  rax
       mov  rax,  qword [rbp-368]
       mov  qword [rbp-520],  rax
       mov  rax,  qword [rbp-384]
       mov  qword [rbp-528],  rax
       mov  rax,  qword [rbp-400]
       mov  qword [rbp-536],  rax
       mov  rax,  qword [rbp-408]
       mov  qword [rbp-544],  rax
       mov  qword [rbp-88],  0
label135:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  80
       jge  label138
label137:
       mov  qword [rbp-552],  1
       jmp  label139
label138:
       mov  qword [rbp-552],  0
label139:
       mov  rcx,  qword [rbp-552]
       cmp  rcx,  0
       jz  label134
label133:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  20
       jge  label144
label143:
       mov  qword [rbp-576],  1
       jmp  label145
label144:
       mov  qword [rbp-576],  0
label145:
       mov  rcx,  qword [rbp-576]
       cmp  rcx,  0
       jz  label141
label140:
       mov  rax,  qword [rbp-520]
       mov  rdx,  qword [rbp-528]
       and  rax,  rdx
       mov  qword [rbp-584],  rax
       mov  rax,  qword [rbp-520]
       not  rax
       mov  qword [rbp-592],  rax
       mov  rax,  qword [rbp-592]
       mov  rdx,  qword [rbp-536]
       and  rax,  rdx
       mov  qword [rbp-600],  rax
       mov  rax,  qword [rbp-584]
       mov  rdx,  qword [rbp-600]
       or  rax,  rdx
       mov  qword [rbp-608],  rax
       mov  rax,  qword [rbp-608]
       mov  qword [rbp-560],  rax
       mov  qword [rbp-568],  1518500249
       jmp  label142
label141:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  40
       jge  label150
label149:
       mov  qword [rbp-616],  1
       jmp  label151
label150:
       mov  qword [rbp-616],  0
label151:
       mov  rcx,  qword [rbp-616]
       cmp  rcx,  0
       jz  label147
label146:
       mov  rax,  qword [rbp-520]
       mov  rdx,  qword [rbp-528]
       xor  rax,  rdx
       mov  qword [rbp-624],  rax
       mov  rax,  qword [rbp-624]
       mov  rdx,  qword [rbp-536]
       xor  rax,  rdx
       mov  qword [rbp-632],  rax
       mov  rax,  qword [rbp-632]
       mov  qword [rbp-560],  rax
       mov  qword [rbp-568],  1859775393
       jmp  label148
label147:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  60
       jge  label156
label155:
       mov  qword [rbp-640],  1
       jmp  label157
label156:
       mov  qword [rbp-640],  0
label157:
       mov  rcx,  qword [rbp-640]
       cmp  rcx,  0
       jz  label153
label152:
       mov  rax,  qword [rbp-520]
       mov  rdx,  qword [rbp-528]
       and  rax,  rdx
       mov  qword [rbp-648],  rax
       mov  rax,  qword [rbp-520]
       mov  rdx,  qword [rbp-536]
       and  rax,  rdx
       mov  qword [rbp-656],  rax
       mov  rax,  qword [rbp-648]
       mov  rdx,  qword [rbp-656]
       or  rax,  rdx
       mov  qword [rbp-664],  rax
       mov  rax,  qword [rbp-528]
       mov  rdx,  qword [rbp-536]
       and  rax,  rdx
       mov  qword [rbp-672],  rax
       mov  rax,  qword [rbp-664]
       mov  rdx,  qword [rbp-672]
       or  rax,  rdx
       mov  qword [rbp-680],  rax
       mov  rax,  qword [rbp-680]
       mov  qword [rbp-560],  rax
       mov  rdi,  48348
       mov  rsi,  36635
       call  lohi
       mov  qword [rbp-688],  rax
       mov  rax,  qword [rbp-688]
       mov  qword [rbp-568],  rax
       jmp  label154
label153:
       mov  rax,  qword [rbp-520]
       mov  rdx,  qword [rbp-528]
       xor  rax,  rdx
       mov  qword [rbp-696],  rax
       mov  rax,  qword [rbp-696]
       mov  rdx,  qword [rbp-536]
       xor  rax,  rdx
       mov  qword [rbp-704],  rax
       mov  rax,  qword [rbp-704]
       mov  qword [rbp-560],  rax
       mov  rdi,  49622
       mov  rsi,  51810
       call  lohi
       mov  qword [rbp-712],  rax
       mov  rax,  qword [rbp-712]
       mov  qword [rbp-568],  rax
       jmp  label154
label154:
       jmp  label148
label148:
       jmp  label142
label142:
       mov  rax,  qword [rbp-512]
       mov  rdi,  rax
       mov  rsi,  5
       call  rotate_left
       mov  qword [rbp-752],  rax
       mov  rax,  qword [rbp-752]
       mov  rdi,  rax
       mov  rax,  qword [rbp-544]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-744],  rax
       mov  rax,  qword [rbp-560]
       mov  rdi,  rax
       mov  rax,  qword [rbp-568]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-760],  rax
       mov  rax,  qword [rbp-744]
       mov  rdi,  rax
       mov  rax,  qword [rbp-760]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-736],  rax
       mov  rax,  qword [rbp-736]
       mov  rdi,  rax
       mov  rdx,  qword[chunks]
       mov  rbx,  qword [rbp-80]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-88]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-728],  rax
       mov  rax,  qword [rbp-728]
       mov  qword [rbp-720],  rax
       mov  rax,  qword [rbp-536]
       mov  qword [rbp-544],  rax
       mov  rax,  qword [rbp-528]
       mov  qword [rbp-536],  rax
       mov  rax,  qword [rbp-520]
       mov  rdi,  rax
       mov  rsi,  30
       call  rotate_left
       mov  qword [rbp-768],  rax
       mov  rax,  qword [rbp-768]
       mov  qword [rbp-528],  rax
       mov  rax,  qword [rbp-512]
       mov  qword [rbp-520],  rax
       mov  rax,  qword [rbp-720]
       mov  qword [rbp-512],  rax
label136:
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-776],  rax
       mov  rax,  qword [rbp-88]
       add  rax,  1
       mov  qword [rbp-88],  rax
       jmp  label135
label134:
       mov  rax,  qword [rbp-360]
       mov  rdi,  rax
       mov  rax,  qword [rbp-512]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-784],  rax
       mov  rax,  qword [rbp-784]
       mov  qword [rbp-360],  rax
       mov  rax,  qword [rbp-368]
       mov  rdi,  rax
       mov  rax,  qword [rbp-520]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-792],  rax
       mov  rax,  qword [rbp-792]
       mov  qword [rbp-368],  rax
       mov  rax,  qword [rbp-384]
       mov  rdi,  rax
       mov  rax,  qword [rbp-528]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-800],  rax
       mov  rax,  qword [rbp-800]
       mov  qword [rbp-384],  rax
       mov  rax,  qword [rbp-400]
       mov  rdi,  rax
       mov  rax,  qword [rbp-536]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-808],  rax
       mov  rax,  qword [rbp-808]
       mov  qword [rbp-400],  rax
       mov  rax,  qword [rbp-408]
       mov  rdi,  rax
       mov  rax,  qword [rbp-544]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-816],  rax
       mov  rax,  qword [rbp-816]
       mov  qword [rbp-408],  rax
label122:
       mov  rax,  qword [rbp-80]
       mov  qword [rbp-824],  rax
       mov  rax,  qword [rbp-80]
       add  rax,  1
       mov  qword [rbp-80],  rax
       jmp  label121
label120:
       mov  rcx,  qword [rbp-360]
       mov  rax,  qword[outputBuffer]
       mov  qword [rax + 8],  rcx
       mov  rcx,  qword [rbp-368]
       mov  rax,  qword[outputBuffer]
       mov  qword [rax + 16],  rcx
       mov  rcx,  qword [rbp-384]
       mov  rax,  qword[outputBuffer]
       mov  qword [rax + 24],  rcx
       mov  rcx,  qword [rbp-400]
       mov  rax,  qword[outputBuffer]
       mov  qword [rax + 32],  rcx
       mov  rcx,  qword [rbp-408]
       mov  rax,  qword[outputBuffer]
       mov  qword [rax + 40],  rcx
       mov  rax,  qword[outputBuffer]
       add  rsp,  832
       pop  rbp
       ret  
       add  rsp,  832
       pop  rbp
       ret  
computeSHA1:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  128
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  0
label160:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  length
       mov  qword [rbp-24],  rax
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       jge  label163
label162:
       mov  qword [rbp-32],  1
       jmp  label164
label163:
       mov  qword [rbp-32],  0
label164:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label159
label158:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       call  ord
       mov  qword [rbp-40],  rax
       mov  rdx,  qword [rbp-40]
       mov  rax,  qword[inputBuffer]
       mov  rcx,  qword [rbp-16]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
label161:
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-16]
       add  rax,  1
       mov  qword [rbp-16],  rax
       jmp  label160
label159:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  length
       mov  qword [rbp-72],  rax
       mov  rax,  qword[inputBuffer]
       mov  rdi,  rax
       mov  rax,  qword [rbp-72]
       mov  rsi,  rax
       call  sha1
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  qword [rbp-56],  rax
       mov  qword [rbp-16],  0
label167:
       mov  rax,  qword [rbp-56]
       mov  rdi,  rax
       call  size
       mov  qword [rbp-80],  rax
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-80]
       cmp  rcx,  rdx
       jge  label170
label169:
       mov  qword [rbp-88],  1
       jmp  label171
label170:
       mov  qword [rbp-88],  0
label171:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  0
       jz  label166
label165:
       mov  rax,  qword [rbp-56]
       mov  rcx,  qword [rbp-16]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  toStringHex
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       mov  rdi,  rax
       call  print
label168:
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-16]
       add  rax,  1
       mov  qword [rbp-16],  rax
       jmp  label167
label166:
       mov  rax,  String_4
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       mov  rdi,  rax
       call  println
       add  rsp,  128
       pop  rbp
       ret  
       add  rsp,  128
       pop  rbp
       ret  
nextLetter:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  64
       mov  qword [rbp-8],  rdi
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  122
       jne  label176
label175:
       mov  qword [rbp-16],  1
       jmp  label177
label176:
       mov  qword [rbp-16],  0
label177:
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jz  label173
label172:
       mov  rax,  1
       neg  rax
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       add  rsp,  64
       pop  rbp
       ret  
       jmp  label174
label173:
       jmp  label174
label174:
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  90
       jne  label182
label181:
       mov  qword [rbp-32],  1
       jmp  label183
label182:
       mov  qword [rbp-32],  0
label183:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label179
label178:
       mov  rax,  97
       add  rsp,  64
       pop  rbp
       ret  
       jmp  label180
label179:
       jmp  label180
label180:
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  57
       jne  label188
label187:
       mov  qword [rbp-40],  1
       jmp  label189
label188:
       mov  qword [rbp-40],  0
label189:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label185
label184:
       mov  rax,  65
       add  rsp,  64
       pop  rbp
       ret  
       jmp  label186
label185:
       jmp  label186
label186:
       mov  rax,  qword [rbp-8]
       add  rax,  1
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       add  rsp,  64
       pop  rbp
       ret  
       add  rsp,  64
       pop  rbp
       ret  
nextText:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  96
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-16]
       sub  rax,  1
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword [rbp-24],  rax
label192:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jl  label195
label194:
       mov  qword [rbp-40],  1
       jmp  label196
label195:
       mov  qword [rbp-40],  0
label196:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label191
label190:
       mov  rax,  qword [rbp-8]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  nextLetter
       mov  qword [rbp-48],  rax
       mov  rdx,  qword [rbp-48]
       mov  rax,  qword [rbp-8]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
       mov  rax,  1
       neg  rax
       mov  qword [rbp-56],  rax
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-24]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       mov  r8,  qword [rbp-56]
       cmp  rbx,  r8
       jne  label201
label200:
       mov  qword [rbp-64],  1
       jmp  label202
label201:
       mov  qword [rbp-64],  0
label202:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label198
label197:
       mov  rax,  qword [rbp-8]
       mov  rcx,  qword [rbp-24]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  48
       jmp  label199
label198:
       mov  rax,  1
       add  rsp,  96
       pop  rbp
       ret  
       jmp  label199
label199:
label193:
       mov  rax,  qword [rbp-24]
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-24]
       sub  rax,  1
       mov  qword [rbp-24],  rax
       jmp  label192
label191:
       mov  rax,  0
       add  rsp,  96
       pop  rbp
       ret  
       add  rsp,  96
       pop  rbp
       ret  
array_equal:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  96
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  size
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  size
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword [rbp-32]
       cmp  rcx,  rdx
       je  label207
label206:
       mov  qword [rbp-40],  1
       jmp  label208
label207:
       mov  qword [rbp-40],  0
label208:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label204
label203:
       mov  rax,  0
       add  rsp,  96
       pop  rbp
       ret  
       jmp  label205
label204:
       jmp  label205
label205:
       mov  qword [rbp-48],  0
label211:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  size
       mov  qword [rbp-56],  rax
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword [rbp-56]
       cmp  rcx,  rdx
       jge  label214
label213:
       mov  qword [rbp-64],  1
       jmp  label215
label214:
       mov  qword [rbp-64],  0
label215:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label210
label209:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-48]
       add  rdx,  1
       mov  rbx,  qword [rcx + rdx * 8]
       mov  r8,  qword [rbp-16]
       mov  r9,  qword [rbp-48]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       cmp  rbx,  r10
       je  label220
label219:
       mov  qword [rbp-72],  1
       jmp  label221
label220:
       mov  qword [rbp-72],  0
label221:
       mov  rcx,  qword [rbp-72]
       cmp  rcx,  0
       jz  label217
label216:
       mov  rax,  0
       add  rsp,  96
       pop  rbp
       ret  
       jmp  label218
label217:
       jmp  label218
label218:
label212:
       mov  rax,  qword [rbp-48]
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-48]
       add  rax,  1
       mov  qword [rbp-48],  rax
       jmp  label211
label210:
       mov  rax,  1
       add  rsp,  96
       pop  rbp
       ret  
       add  rsp,  96
       pop  rbp
       ret  
crackSHA1:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  304
       mov  qword [rbp-8],  rdi
       mov  rdi,  48
       call  malloc
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rax + 0],  5
       mov  rax,  qword [rbp-24]
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  length
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  40
       je  label226
label225:
       mov  qword [rbp-40],  1
       jmp  label227
label226:
       mov  qword [rbp-40],  0
label227:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label223
label222:
       mov  rax,  String_5
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  rdi,  rax
       call  println
       add  rsp,  304
       pop  rbp
       ret  
       jmp  label224
label223:
       jmp  label224
label224:
       mov  qword [rbp-56],  0
label230:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  5
       jge  label233
label232:
       mov  qword [rbp-64],  1
       jmp  label234
label233:
       mov  qword [rbp-64],  0
label234:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label229
label228:
       mov  rax,  qword [rbp-16]
       mov  rcx,  qword [rbp-56]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  0
label231:
       mov  rax,  qword [rbp-56]
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-56]
       add  rax,  1
       mov  qword [rbp-56],  rax
       jmp  label230
label229:
       mov  qword [rbp-56],  0
label237:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  40
       jge  label240
label239:
       mov  qword [rbp-80],  1
       jmp  label241
label240:
       mov  qword [rbp-80],  0
label241:
       mov  rcx,  qword [rbp-80]
       cmp  rcx,  0
       jz  label236
label235:
       mov  rax,  qword [rbp-56]
       mov  rcx,  8
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-56]
       mov  rcx,  8
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-56]
       add  rax,  3
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-56]
       mov  rsi,  rax
       mov  rax,  qword [rbp-120]
       mov  rdx,  rax
       call  substring
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       mov  rdi,  rax
       call  hex2int
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-56]
       mov  rcx,  4
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-128]
       mov  rdx,  rax
       mov  rcx,  2
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-136],  rdx
       mov  rax,  1
       mov  rcx,  qword [rbp-136]
       sub  rax,  rcx
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-144]
       imul  rax,  16
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-104]
       mov  rdx,  qword [rbp-152]
       mov  rcx,  rdx
       shl  rax,  cl
       mov  qword [rbp-160],  rax
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-96]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r8,  qword [rbp-160]
       or  rax,  r8
       mov  qword [rbp-168],  rax
       mov  rdx,  qword [rbp-168]
       mov  rax,  qword [rbp-16]
       mov  rcx,  qword [rbp-88]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
label238:
       mov  rax,  qword [rbp-56]
       add  rax,  4
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-176]
       mov  qword [rbp-56],  rax
       jmp  label237
label236:
       mov  qword [rbp-184],  4
       mov  qword [rbp-192],  1
label244:
       mov  rcx,  qword [rbp-192]
       mov  rdx,  qword [rbp-184]
       cmp  rcx,  rdx
       jg  label247
label246:
       mov  qword [rbp-200],  1
       jmp  label248
label247:
       mov  qword [rbp-200],  0
label248:
       mov  rcx,  qword [rbp-200]
       cmp  rcx,  0
       jz  label243
label242:
       mov  qword [rbp-56],  0
label251:
       mov  rcx,  qword [rbp-56]
       mov  rdx,  qword [rbp-192]
       cmp  rcx,  rdx
       jge  label254
label253:
       mov  qword [rbp-208],  1
       jmp  label255
label254:
       mov  qword [rbp-208],  0
label255:
       mov  rcx,  qword [rbp-208]
       cmp  rcx,  0
       jz  label250
label249:
       mov  rax,  qword[inputBuffer]
       mov  rcx,  qword [rbp-56]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  48
label252:
       mov  rax,  qword [rbp-56]
       mov  qword [rbp-216],  rax
       mov  rax,  qword [rbp-56]
       add  rax,  1
       mov  qword [rbp-56],  rax
       jmp  label251
label250:
label258:
       mov  rcx,  1
       cmp  rcx,  0
       jz  label257
label256:
       mov  rax,  qword[inputBuffer]
       mov  rdi,  rax
       mov  rax,  qword [rbp-192]
       mov  rsi,  rax
       call  sha1
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-232]
       mov  qword [rbp-224],  rax
       mov  rax,  qword [rbp-224]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       call  array_equal
       mov  qword [rbp-240],  rax
       mov  rcx,  qword [rbp-240]
       cmp  rcx,  0
       jz  label260
label259:
       mov  qword [rbp-56],  0
label264:
       mov  rcx,  qword [rbp-56]
       mov  rdx,  qword [rbp-192]
       cmp  rcx,  rdx
       jge  label267
label266:
       mov  qword [rbp-248],  1
       jmp  label268
label267:
       mov  qword [rbp-248],  0
label268:
       mov  rcx,  qword [rbp-248]
       cmp  rcx,  0
       jz  label263
label262:
       mov  rax,  qword[inputBuffer]
       mov  rcx,  qword [rbp-56]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  int2chr
       mov  qword [rbp-256],  rax
       mov  rax,  qword [rbp-256]
       mov  rdi,  rax
       call  print
label265:
       mov  rax,  qword [rbp-56]
       mov  qword [rbp-264],  rax
       mov  rax,  qword [rbp-56]
       add  rax,  1
       mov  qword [rbp-56],  rax
       jmp  label264
label263:
       mov  rax,  String_6
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-272]
       mov  rdi,  rax
       call  println
       add  rsp,  304
       pop  rbp
       ret  
       jmp  label261
label260:
       jmp  label261
label261:
       mov  rax,  qword[inputBuffer]
       mov  rdi,  rax
       mov  rax,  qword [rbp-192]
       mov  rsi,  rax
       call  nextText
       mov  qword [rbp-280],  rax
       mov  rax,  qword [rbp-280]
       xor  rax,  1
       mov  qword [rbp-288],  rax
       mov  rcx,  qword [rbp-288]
       cmp  rcx,  0
       jz  label270
label269:
       jmp  label257
       jmp  label271
label270:
       jmp  label271
label271:
       jmp  label258
label257:
label245:
       mov  rax,  qword [rbp-192]
       mov  qword [rbp-296],  rax
       mov  rax,  qword [rbp-192]
       add  rax,  1
       mov  qword [rbp-192],  rax
       jmp  label244
label243:
       mov  rax,  String_7
       mov  qword [rbp-304],  rax
       mov  rax,  qword [rbp-304]
       mov  rdi,  rax
       call  println
       add  rsp,  304
       pop  rbp
       ret  
       add  rsp,  304
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  rax,  String_0
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword[asciiTable],  rax
       mov  rax,  qword[MAXCHUNK]
       sub  rax,  1
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       imul  rax,  64
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       sub  rax,  16
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword[MAXLENGTH],  rax
       mov  rcx,  qword[MAXCHUNK]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-40],  rax
       mov  rcx,  qword[MAXCHUNK]
       mov  rax,  qword [rbp-40]
       mov  qword [rax + 0],  rcx
       mov  qword [rbp-48],  0
label88:
       mov  rdi,  648
       call  malloc
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword [rbp-48]
       add  rdx,  1
       mov  qword [rcx + rdx * 8],  rax
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword [rbp-48]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 0],  80
       mov  qword [rbp-56],  0
       mov  rax,  qword [rbp-48]
       add  rax,  1
       mov  qword [rbp-48],  rax
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword[MAXCHUNK]
       cmp  rcx,  rdx
       jg  label89
label89:
       mov  rax,  qword [rbp-40]
       mov  qword[chunks],  rax
       mov  rcx,  qword[MAXLENGTH]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-72],  rax
       mov  rcx,  qword[MAXLENGTH]
       mov  rax,  qword [rbp-72]
       mov  qword [rax + 0],  rcx
       mov  rax,  qword [rbp-72]
       mov  qword[inputBuffer],  rax
       mov  rdi,  48
       call  malloc
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  qword [rax + 0],  5
       mov  rax,  qword [rbp-80]
       mov  qword[outputBuffer],  rax
label274:
       mov  rcx,  1
       cmp  rcx,  0
       jz  label273
label272:
       call  getInt
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rbp-8],  rax
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  0
       jne  label279
label278:
       mov  qword [rbp-32],  1
       jmp  label280
label279:
       mov  qword [rbp-32],  0
label280:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label276
label275:
       jmp  label273
       jmp  label277
label276:
       jmp  label277
label277:
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  1
       jne  label285
label284:
       mov  qword [rbp-40],  1
       jmp  label286
label285:
       mov  qword [rbp-40],  0
label286:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label282
label281:
       call  getString
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  computeSHA1
       jmp  label283
label282:
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  2
       jne  label291
label290:
       mov  qword [rbp-56],  1
       jmp  label292
label291:
       mov  qword [rbp-56],  0
label292:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label288
label287:
       call  getString
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  crackSHA1
       jmp  label289
label288:
       jmp  label289
label289:
       jmp  label283
label283:
       jmp  label274
label273:
       mov  rax,  0
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  

section .data
       dq  95
String_0:
       db  32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 0
       dq  0
String_1:
       db  0
       dq  0
String_2:
       db  0
       dq  18
String_3:
       db  110, 67, 104, 117, 110, 107, 32, 62, 32, 77, 65, 88, 67, 72, 85, 78, 75, 33, 0
       dq  0
String_4:
       db  0
       dq  13
String_5:
       db  73, 110, 118, 97, 108, 105, 100, 32, 105, 110, 112, 117, 116, 0
       dq  0
String_6:
       db  0
       dq  10
String_7:
       db  78, 111, 116, 32, 70, 111, 117, 110, 100, 33, 0
MAXCHUNK:
       dq  100

section .bss

asciiTable:       resq  1
MAXLENGTH:       resq  1
chunks:       resq  1
inputBuffer:       resq  1
outputBuffer:       resq  1


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
