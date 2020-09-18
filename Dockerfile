FROM mcr.microsoft.com/windows/servercore:1803 as installer

SHELL ["powershell", "-Command", "$ErrorActionPreference = 'Stop';$ProgressPreference='silentlyContinue';"]

RUN Invoke-WebRequest -OutFile nodejs.zip -UseBasicParsing "https://nodejs.org/dist/v12.4.0/node-v12.4.0-win-x64.zip"; Expand-Archive nodejs.zip -DestinationPath C:/DANNYE/; Rename-Item "C:\\DANNYE\\node-v12.4.0-win-x64" c:\\DANNYE\\nodejs

FROM mcr.microsoft.com/windows/nanoserver:1803

WORKDIR C:/DANNYE/nodejs
COPY --from=installer C:/DANNYE/nodejs/ .
RUN SETX PATH C:/DANNYE/nodejs
RUN npm config set registry https://registry.npmjs.org/