//
//  AppSettings.m
//

#import "AppSettings.h"

@implementation AppSettings

- (void)fetch:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* result = nil;
    @try {
        NSDictionary *appSettingsDictionary = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"AppSettings"];
        result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary: [appSettingsDictionary copy]];
    } @catch (NSException * e) {
        result = [CDVPluginResult resultWithStatus:CDVCommandStatus_NO_RESULT messageAsString:[e reason]];
    } @finally {
        [self.commandDelegate sendPluginResult:result callbackId:[command callbackId]];
    }
}

@end
