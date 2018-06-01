global    N
global    main
global    k
global    j
global    h
global    i
global    total


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
       sub  rsp,  832
       mov  qword[N],  6
       mov  qword [rbp-8],  1
label2:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jg  label5
label4:
       mov  qword [rbp-56],  1
       jmp  label6
label5:
       mov  qword [rbp-56],  0
label6:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label1
label0:
       mov  qword [rbp-16],  1
label9:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jg  label12
label11:
       mov  qword [rbp-64],  1
       jmp  label13
label12:
       mov  qword [rbp-64],  0
label13:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label8
label7:
       mov  qword [rbp-24],  1
label16:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jg  label19
label18:
       mov  qword [rbp-72],  1
       jmp  label20
label19:
       mov  qword [rbp-72],  0
label20:
       mov  rcx,  qword [rbp-72]
       cmp  rcx,  0
       jz  label15
label14:
       mov  qword [rbp-32],  1
label23:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jg  label26
label25:
       mov  qword [rbp-80],  1
       jmp  label27
label26:
       mov  qword [rbp-80],  0
label27:
       mov  rcx,  qword [rbp-80]
       cmp  rcx,  0
       jz  label22
label21:
       mov  qword [rbp-40],  1
label30:
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jg  label33
label32:
       mov  qword [rbp-88],  1
       jmp  label34
label33:
       mov  qword [rbp-88],  0
label34:
       mov  rcx,  qword [rbp-88]
       cmp  rcx,  0
       jz  label29
label28:
       mov  qword [rbp-48],  1
label37:
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword[N]
       cmp  rcx,  rdx
       jg  label40
label39:
       mov  qword [rbp-96],  1
       jmp  label41
label40:
       mov  qword [rbp-96],  0
label41:
       mov  rcx,  qword [rbp-96]
       cmp  rcx,  0
       jz  label36
label35:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-16]
       cmp  rcx,  rdx
       je  label246
label245:
       mov  qword [rbp-104],  1
       jmp  label247
label246:
       mov  qword [rbp-104],  0
label247:
       mov  rcx,  qword [rbp-104]
       cmp  rcx,  0
       jz  label243
label240:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       je  label249
label248:
       mov  qword [rbp-112],  1
       jmp  label250
label249:
       mov  qword [rbp-112],  0
label250:
       jz  label243
label242:
       mov  qword [rbp-120],  1
       jmp  label244
label243:
       mov  qword [rbp-120],  0
label244:
       mov  rcx,  qword [rbp-120]
       cmp  rcx,  0
       jz  label238
label235:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-32]
       cmp  rcx,  rdx
       je  label252
label251:
       mov  qword [rbp-128],  1
       jmp  label253
label252:
       mov  qword [rbp-128],  0
label253:
       jz  label238
label237:
       mov  qword [rbp-136],  1
       jmp  label239
label238:
       mov  qword [rbp-136],  0
label239:
       mov  rcx,  qword [rbp-136]
       cmp  rcx,  0
       jz  label233
label230:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-40]
       cmp  rcx,  rdx
       je  label255
label254:
       mov  qword [rbp-144],  1
       jmp  label256
label255:
       mov  qword [rbp-144],  0
label256:
       jz  label233
label232:
       mov  qword [rbp-152],  1
       jmp  label234
label233:
       mov  qword [rbp-152],  0
label234:
       mov  rcx,  qword [rbp-152]
       cmp  rcx,  0
       jz  label228
label225:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-48]
       cmp  rcx,  rdx
       je  label258
label257:
       mov  qword [rbp-160],  1
       jmp  label259
label258:
       mov  qword [rbp-160],  0
label259:
       jz  label228
label227:
       mov  qword [rbp-168],  1
       jmp  label229
label228:
       mov  qword [rbp-168],  0
label229:
       mov  rcx,  qword [rbp-168]
       cmp  rcx,  0
       jz  label223
label220:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword[h]
       cmp  rcx,  rdx
       je  label261
label260:
       mov  qword [rbp-176],  1
       jmp  label262
label261:
       mov  qword [rbp-176],  0
label262:
       jz  label223
label222:
       mov  qword [rbp-184],  1
       jmp  label224
label223:
       mov  qword [rbp-184],  0
label224:
       mov  rcx,  qword [rbp-184]
       cmp  rcx,  0
       jz  label218
label215:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword[i]
       cmp  rcx,  rdx
       je  label264
label263:
       mov  qword [rbp-192],  1
       jmp  label265
label264:
       mov  qword [rbp-192],  0
label265:
       jz  label218
label217:
       mov  qword [rbp-200],  1
       jmp  label219
label218:
       mov  qword [rbp-200],  0
label219:
       mov  rcx,  qword [rbp-200]
       cmp  rcx,  0
       jz  label213
label210:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword[j]
       cmp  rcx,  rdx
       je  label267
label266:
       mov  qword [rbp-208],  1
       jmp  label268
label267:
       mov  qword [rbp-208],  0
label268:
       jz  label213
label212:
       mov  qword [rbp-216],  1
       jmp  label214
label213:
       mov  qword [rbp-216],  0
label214:
       mov  rcx,  qword [rbp-216]
       cmp  rcx,  0
       jz  label208
label205:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword[k]
       cmp  rcx,  rdx
       je  label270
label269:
       mov  qword [rbp-224],  1
       jmp  label271
label270:
       mov  qword [rbp-224],  0
label271:
       jz  label208
label207:
       mov  qword [rbp-232],  1
       jmp  label209
label208:
       mov  qword [rbp-232],  0
label209:
       mov  rcx,  qword [rbp-232]
       cmp  rcx,  0
       jz  label203
label200:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-24]
       cmp  rcx,  rdx
       je  label273
label272:
       mov  qword [rbp-240],  1
       jmp  label274
label273:
       mov  qword [rbp-240],  0
label274:
       jz  label203
label202:
       mov  qword [rbp-248],  1
       jmp  label204
label203:
       mov  qword [rbp-248],  0
label204:
       mov  rcx,  qword [rbp-248]
       cmp  rcx,  0
       jz  label198
label195:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-32]
       cmp  rcx,  rdx
       je  label276
label275:
       mov  qword [rbp-256],  1
       jmp  label277
label276:
       mov  qword [rbp-256],  0
label277:
       jz  label198
label197:
       mov  qword [rbp-264],  1
       jmp  label199
label198:
       mov  qword [rbp-264],  0
label199:
       mov  rcx,  qword [rbp-264]
       cmp  rcx,  0
       jz  label193
label190:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-40]
       cmp  rcx,  rdx
       je  label279
label278:
       mov  qword [rbp-272],  1
       jmp  label280
label279:
       mov  qword [rbp-272],  0
label280:
       jz  label193
label192:
       mov  qword [rbp-280],  1
       jmp  label194
label193:
       mov  qword [rbp-280],  0
label194:
       mov  rcx,  qword [rbp-280]
       cmp  rcx,  0
       jz  label188
label185:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword [rbp-48]
       cmp  rcx,  rdx
       je  label282
label281:
       mov  qword [rbp-288],  1
       jmp  label283
label282:
       mov  qword [rbp-288],  0
label283:
       jz  label188
label187:
       mov  qword [rbp-296],  1
       jmp  label189
label188:
       mov  qword [rbp-296],  0
label189:
       mov  rcx,  qword [rbp-296]
       cmp  rcx,  0
       jz  label183
label180:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword[h]
       cmp  rcx,  rdx
       je  label285
label284:
       mov  qword [rbp-304],  1
       jmp  label286
label285:
       mov  qword [rbp-304],  0
label286:
       jz  label183
label182:
       mov  qword [rbp-312],  1
       jmp  label184
label183:
       mov  qword [rbp-312],  0
label184:
       mov  rcx,  qword [rbp-312]
       cmp  rcx,  0
       jz  label178
label175:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword[i]
       cmp  rcx,  rdx
       je  label288
label287:
       mov  qword [rbp-320],  1
       jmp  label289
label288:
       mov  qword [rbp-320],  0
label289:
       jz  label178
label177:
       mov  qword [rbp-328],  1
       jmp  label179
label178:
       mov  qword [rbp-328],  0
label179:
       mov  rcx,  qword [rbp-328]
       cmp  rcx,  0
       jz  label173
label170:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword[j]
       cmp  rcx,  rdx
       je  label291
label290:
       mov  qword [rbp-336],  1
       jmp  label292
label291:
       mov  qword [rbp-336],  0
label292:
       jz  label173
label172:
       mov  qword [rbp-344],  1
       jmp  label174
label173:
       mov  qword [rbp-344],  0
label174:
       mov  rcx,  qword [rbp-344]
       cmp  rcx,  0
       jz  label168
label165:
       mov  rcx,  qword [rbp-16]
       mov  rdx,  qword[k]
       cmp  rcx,  rdx
       je  label294
label293:
       mov  qword [rbp-352],  1
       jmp  label295
label294:
       mov  qword [rbp-352],  0
label295:
       jz  label168
label167:
       mov  qword [rbp-360],  1
       jmp  label169
label168:
       mov  qword [rbp-360],  0
label169:
       mov  rcx,  qword [rbp-360]
       cmp  rcx,  0
       jz  label163
label160:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword [rbp-32]
       cmp  rcx,  rdx
       je  label297
label296:
       mov  qword [rbp-368],  1
       jmp  label298
label297:
       mov  qword [rbp-368],  0
label298:
       jz  label163
label162:
       mov  qword [rbp-376],  1
       jmp  label164
label163:
       mov  qword [rbp-376],  0
label164:
       mov  rcx,  qword [rbp-376]
       cmp  rcx,  0
       jz  label158
label155:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword [rbp-40]
       cmp  rcx,  rdx
       je  label300
label299:
       mov  qword [rbp-384],  1
       jmp  label301
label300:
       mov  qword [rbp-384],  0
label301:
       jz  label158
label157:
       mov  qword [rbp-392],  1
       jmp  label159
label158:
       mov  qword [rbp-392],  0
label159:
       mov  rcx,  qword [rbp-392]
       cmp  rcx,  0
       jz  label153
label150:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword [rbp-48]
       cmp  rcx,  rdx
       je  label303
label302:
       mov  qword [rbp-400],  1
       jmp  label304
label303:
       mov  qword [rbp-400],  0
label304:
       jz  label153
label152:
       mov  qword [rbp-408],  1
       jmp  label154
label153:
       mov  qword [rbp-408],  0
label154:
       mov  rcx,  qword [rbp-408]
       cmp  rcx,  0
       jz  label148
label145:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[h]
       cmp  rcx,  rdx
       je  label306
label305:
       mov  qword [rbp-416],  1
       jmp  label307
label306:
       mov  qword [rbp-416],  0
label307:
       jz  label148
label147:
       mov  qword [rbp-424],  1
       jmp  label149
label148:
       mov  qword [rbp-424],  0
label149:
       mov  rcx,  qword [rbp-424]
       cmp  rcx,  0
       jz  label143
label140:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[i]
       cmp  rcx,  rdx
       je  label309
label308:
       mov  qword [rbp-432],  1
       jmp  label310
label309:
       mov  qword [rbp-432],  0
label310:
       jz  label143
label142:
       mov  qword [rbp-440],  1
       jmp  label144
label143:
       mov  qword [rbp-440],  0
label144:
       mov  rcx,  qword [rbp-440]
       cmp  rcx,  0
       jz  label138
label135:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[j]
       cmp  rcx,  rdx
       je  label312
label311:
       mov  qword [rbp-448],  1
       jmp  label313
label312:
       mov  qword [rbp-448],  0
label313:
       jz  label138
label137:
       mov  qword [rbp-456],  1
       jmp  label139
label138:
       mov  qword [rbp-456],  0
label139:
       mov  rcx,  qword [rbp-456]
       cmp  rcx,  0
       jz  label133
label130:
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword[k]
       cmp  rcx,  rdx
       je  label315
label314:
       mov  qword [rbp-464],  1
       jmp  label316
label315:
       mov  qword [rbp-464],  0
label316:
       jz  label133
label132:
       mov  qword [rbp-472],  1
       jmp  label134
label133:
       mov  qword [rbp-472],  0
label134:
       mov  rcx,  qword [rbp-472]
       cmp  rcx,  0
       jz  label128
label125:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword [rbp-40]
       cmp  rcx,  rdx
       je  label318
label317:
       mov  qword [rbp-480],  1
       jmp  label319
label318:
       mov  qword [rbp-480],  0
label319:
       jz  label128
label127:
       mov  qword [rbp-488],  1
       jmp  label129
label128:
       mov  qword [rbp-488],  0
label129:
       mov  rcx,  qword [rbp-488]
       cmp  rcx,  0
       jz  label123
label120:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword [rbp-48]
       cmp  rcx,  rdx
       je  label321
label320:
       mov  qword [rbp-496],  1
       jmp  label322
label321:
       mov  qword [rbp-496],  0
label322:
       jz  label123
label122:
       mov  qword [rbp-504],  1
       jmp  label124
label123:
       mov  qword [rbp-504],  0
label124:
       mov  rcx,  qword [rbp-504]
       cmp  rcx,  0
       jz  label118
label115:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[h]
       cmp  rcx,  rdx
       je  label324
label323:
       mov  qword [rbp-512],  1
       jmp  label325
label324:
       mov  qword [rbp-512],  0
label325:
       jz  label118
label117:
       mov  qword [rbp-520],  1
       jmp  label119
label118:
       mov  qword [rbp-520],  0
label119:
       mov  rcx,  qword [rbp-520]
       cmp  rcx,  0
       jz  label113
label110:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[i]
       cmp  rcx,  rdx
       je  label327
label326:
       mov  qword [rbp-528],  1
       jmp  label328
label327:
       mov  qword [rbp-528],  0
label328:
       jz  label113
label112:
       mov  qword [rbp-536],  1
       jmp  label114
label113:
       mov  qword [rbp-536],  0
label114:
       mov  rcx,  qword [rbp-536]
       cmp  rcx,  0
       jz  label108
label105:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[j]
       cmp  rcx,  rdx
       je  label330
label329:
       mov  qword [rbp-544],  1
       jmp  label331
label330:
       mov  qword [rbp-544],  0
label331:
       jz  label108
label107:
       mov  qword [rbp-552],  1
       jmp  label109
label108:
       mov  qword [rbp-552],  0
label109:
       mov  rcx,  qword [rbp-552]
       cmp  rcx,  0
       jz  label103
label100:
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword[k]
       cmp  rcx,  rdx
       je  label333
label332:
       mov  qword [rbp-560],  1
       jmp  label334
label333:
       mov  qword [rbp-560],  0
label334:
       jz  label103
label102:
       mov  qword [rbp-568],  1
       jmp  label104
label103:
       mov  qword [rbp-568],  0
label104:
       mov  rcx,  qword [rbp-568]
       cmp  rcx,  0
       jz  label98
label95:
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword [rbp-48]
       cmp  rcx,  rdx
       je  label336
label335:
       mov  qword [rbp-576],  1
       jmp  label337
label336:
       mov  qword [rbp-576],  0
label337:
       jz  label98
label97:
       mov  qword [rbp-584],  1
       jmp  label99
label98:
       mov  qword [rbp-584],  0
label99:
       mov  rcx,  qword [rbp-584]
       cmp  rcx,  0
       jz  label93
label90:
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword[h]
       cmp  rcx,  rdx
       je  label339
label338:
       mov  qword [rbp-592],  1
       jmp  label340
label339:
       mov  qword [rbp-592],  0
label340:
       jz  label93
label92:
       mov  qword [rbp-600],  1
       jmp  label94
label93:
       mov  qword [rbp-600],  0
label94:
       mov  rcx,  qword [rbp-600]
       cmp  rcx,  0
       jz  label88
label85:
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword[i]
       cmp  rcx,  rdx
       je  label342
label341:
       mov  qword [rbp-608],  1
       jmp  label343
label342:
       mov  qword [rbp-608],  0
label343:
       jz  label88
label87:
       mov  qword [rbp-616],  1
       jmp  label89
label88:
       mov  qword [rbp-616],  0
label89:
       mov  rcx,  qword [rbp-616]
       cmp  rcx,  0
       jz  label83
label80:
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword[j]
       cmp  rcx,  rdx
       je  label345
label344:
       mov  qword [rbp-624],  1
       jmp  label346
label345:
       mov  qword [rbp-624],  0
label346:
       jz  label83
label82:
       mov  qword [rbp-632],  1
       jmp  label84
label83:
       mov  qword [rbp-632],  0
label84:
       mov  rcx,  qword [rbp-632]
       cmp  rcx,  0
       jz  label78
label75:
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword[k]
       cmp  rcx,  rdx
       je  label348
label347:
       mov  qword [rbp-640],  1
       jmp  label349
label348:
       mov  qword [rbp-640],  0
label349:
       jz  label78
label77:
       mov  qword [rbp-648],  1
       jmp  label79
label78:
       mov  qword [rbp-648],  0
label79:
       mov  rcx,  qword [rbp-648]
       cmp  rcx,  0
       jz  label73
label70:
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword[h]
       cmp  rcx,  rdx
       je  label351
label350:
       mov  qword [rbp-656],  1
       jmp  label352
label351:
       mov  qword [rbp-656],  0
label352:
       jz  label73
label72:
       mov  qword [rbp-664],  1
       jmp  label74
label73:
       mov  qword [rbp-664],  0
label74:
       mov  rcx,  qword [rbp-664]
       cmp  rcx,  0
       jz  label68
label65:
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword[i]
       cmp  rcx,  rdx
       je  label354
label353:
       mov  qword [rbp-672],  1
       jmp  label355
label354:
       mov  qword [rbp-672],  0
label355:
       jz  label68
label67:
       mov  qword [rbp-680],  1
       jmp  label69
label68:
       mov  qword [rbp-680],  0
label69:
       mov  rcx,  qword [rbp-680]
       cmp  rcx,  0
       jz  label63
label60:
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword[j]
       cmp  rcx,  rdx
       je  label357
label356:
       mov  qword [rbp-688],  1
       jmp  label358
label357:
       mov  qword [rbp-688],  0
label358:
       jz  label63
label62:
       mov  qword [rbp-696],  1
       jmp  label64
label63:
       mov  qword [rbp-696],  0
label64:
       mov  rcx,  qword [rbp-696]
       cmp  rcx,  0
       jz  label58
label55:
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword[k]
       cmp  rcx,  rdx
       je  label360
label359:
       mov  qword [rbp-704],  1
       jmp  label361
label360:
       mov  qword [rbp-704],  0
label361:
       jz  label58
label57:
       mov  qword [rbp-712],  1
       jmp  label59
label58:
       mov  qword [rbp-712],  0
label59:
       mov  rcx,  qword [rbp-712]
       cmp  rcx,  0
       jz  label53
label50:
       mov  rcx,  qword[i]
       mov  rdx,  qword[j]
       cmp  rcx,  rdx
       je  label363
label362:
       mov  qword [rbp-720],  1
       jmp  label364
label363:
       mov  qword [rbp-720],  0
label364:
       jz  label53
label52:
       mov  qword [rbp-728],  1
       jmp  label54
label53:
       mov  qword [rbp-728],  0
label54:
       mov  rcx,  qword [rbp-728]
       cmp  rcx,  0
       jz  label48
label45:
       mov  rcx,  qword[h]
       mov  rdx,  qword[k]
       cmp  rcx,  rdx
       je  label366
label365:
       mov  qword [rbp-736],  1
       jmp  label367
label366:
       mov  qword [rbp-736],  0
label367:
       jz  label48
label47:
       mov  qword [rbp-744],  1
       jmp  label49
label48:
       mov  qword [rbp-744],  0
label49:
       mov  rcx,  qword [rbp-744]
       cmp  rcx,  0
       jz  label43
label42:
       mov  rax,  qword[total]
       mov  qword [rbp-752],  rax
       mov  rax,  qword[total]
       add  rax,  1
       mov  qword[total],  rax
       jmp  label44
label43:
       jmp  label44
label44:
label38:
       mov  rax,  qword [rbp-48]
       mov  qword [rbp-760],  rax
       mov  rax,  qword [rbp-48]
       add  rax,  1
       mov  qword [rbp-48],  rax
       jmp  label37
label36:
label31:
       mov  rax,  qword [rbp-40]
       mov  qword [rbp-768],  rax
       mov  rax,  qword [rbp-40]
       add  rax,  1
       mov  qword [rbp-40],  rax
       jmp  label30
label29:
label24:
       mov  rax,  qword [rbp-32]
       mov  qword [rbp-776],  rax
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       jmp  label23
label22:
label17:
       mov  rax,  qword [rbp-24]
       mov  qword [rbp-784],  rax
       mov  rax,  qword [rbp-24]
       add  rax,  1
       mov  qword [rbp-24],  rax
       jmp  label16
label15:
label10:
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-792],  rax
       mov  rax,  qword [rbp-16]
       add  rax,  1
       mov  qword [rbp-16],  rax
       jmp  label9
label8:
label3:
       mov  rax,  qword [rbp-8]
       mov  qword [rbp-800],  rax
       mov  rax,  qword [rbp-8]
       add  rax,  1
       mov  qword [rbp-8],  rax
       jmp  label2
label1:
       mov  rax,  qword[total]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-808],  rax
       mov  rax,  qword [rbp-808]
       mov  rdi,  rax
       call  println
       mov  rax,  0
       add  rsp,  832
       pop  rbp
       ret  
       add  rsp,  832
       pop  rbp
       ret  

section .data
h:
       dq  99
i:
       dq  100
j:
       dq  101
k:
       dq  102
total:
       dq  0

section .bss

N:       resq  1


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
