#$language = "VBScript"
#$interface = "1.0"

Sub Main

    Dim fso,file1,line,str1,params,PASWD,JUMP


    'keberos 密码
    PASWD = "xx"
    JUMP = "xx"
    HOST = "/S ttt"

    Const ForReading = 1, ForWriting = 2, ForAppending = 8

    Set fso = CreateObject("Scripting.FileSystemObject")
    Set file1 = fso.OpenTextFile("d:\onlineIp.txt",Forreading, False)
    crt.Screen.Synchronous = True
    DO While file1.AtEndOfStream <> True
       '读出每行
       line = file1.ReadLine
       params = Split (line)
       '连接到58
       Dim objTab1
       Set objTab1 = crt.Session.ConnectInTab (HOST)

       '登录到线上机器
       objTab1.Screen.Synchronous = True
       objTab1.Screen.WaitForString "):", 5
       objTab1.Screen.Send "w" & JUMP & chr(13)
	   objTab1.Screen.WaitForString "input permsion" & chr(124) & "select number:"
	   objTab1.Screen.Send "2" & chr(13)
	   objTab1.Screen.WaitForString "@58OS.ORG: "
	   objTab1.Screen.Send PASWD & chr(13)
	   objTab1.Screen.WaitForString "[0mtjtx-84-66", 3
	   objTab1.Screen.Send "cd shangzhidong" & chr(9) & chr(13)
	   objTab1.Screen.Send "ssh " & params(0) & chr(9) & chr(13)
       objTab1.Screen.Send "cd " & params(1) & chr(9) & chr(13)
       objTab1.Caption = params(0)
       loop


   	   Dim objTab2
       Set objTab2 = crt.Session.ConnectInTab (HOST)

       '登录到线上机器
       objTab2.Screen.Synchronous = True
       objTab2.Screen.WaitForString "):", 5
       objTab2.Screen.Send "w" & JUMP & chr(13)
	   objTab2.Screen.WaitForString "input permsion" & chr(124) & "select number:"
	   objTab2.Screen.Send "2" & chr(13)
	   objTab2.Screen.WaitForString "@58OS.ORG: "
	   objTab2.Screen.Send PASWD & chr(13)
	   objTab2.Screen.WaitForString "[0mtjtx-84-66 ", 3
	   objTab2.Screen.Send "cd shangzhidong" & chr(9) & chr(13)
    crt.Screen.Synchronous = False
End Sub
