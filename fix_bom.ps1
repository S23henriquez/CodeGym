$layouts = Get-ChildItem 'app\src\main\res\layout\*.xml'
foreach ($f in $layouts) {
    $content = [System.IO.File]::ReadAllText($f.FullName, [System.Text.Encoding]::UTF8)
    $clean = $content.TrimStart()
    [System.IO.File]::WriteAllText($f.FullName, $clean, [System.Text.UTF8Encoding]::new($false))
    Write-Host "Limpiado: $($f.Name)"
}
Write-Host "Todos listos"