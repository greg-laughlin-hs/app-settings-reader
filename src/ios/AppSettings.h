//
//  AppPreferences.h
//
//

#import <Cordova/CDV.h>
#import <Cordova/CDVViewController.h>

@interface AppSettings : CDVPlugin

- (void)fetch:(CDVInvokedUrlCommand*)command;

@end
